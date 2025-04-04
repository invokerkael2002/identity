package com.ex.identity.configuration;

import com.ex.identity.constant.PredefinedRole;
import com.ex.identity.entity.Role;
import com.ex.identity.entity.User;
import com.ex.identity.repository.RoleRepository;
import com.ex.identity.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
         if (userRepository.findUserByUsername("admin@gmail.com").isEmpty()){
                var roles = new HashSet<Role>();
             Role adminRole = roleRepository.save(Role.builder()
                     .name(PredefinedRole.ADMIN_ROLE)
                     .description("Admin role")
                     .build());
                User user = User.builder()
                        .username("admin@gmail.com")
                        .password(passwordEncoder.encode("123456"))
                        .roles(roles)
                        .build();
                userRepository.save(user);
                log.warn("admin user has been created with default password, please change it");
            }
        };
    }
}
