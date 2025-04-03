package com.ex.identity.configuration;

import com.ex.identity.dto.request.IntrospectRequest;
import com.ex.identity.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
public class CustomJWTDecoder implements JwtDecoder {
    @Value("${jwt.signerKey}")
    private String SIGNER_KEY;
    private NimbusJwtDecoder nimbusJwtDecoder = null;

    @Autowired
    public AuthenticationService authenticationService;

    @Override
    public Jwt decode(String token) throws JwtException{
        try{
            var result = authenticationService.introspect(IntrospectRequest.builder()
                            .token(token)
                            .build());
            if(!result.isValid())
                throw new JwtException("token invalid");
        } catch (ParseException|JOSEException e) {
            throw new JwtException(e.getMessage());
        }

        if(Objects.isNull(nimbusJwtDecoder)){
        SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(),"HS512");
                nimbusJwtDecoder =  NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
        }
        return nimbusJwtDecoder.decode(token);
    }

}

