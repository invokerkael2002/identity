package com.ex.identity.service;

import com.ex.identity.dto.request.RoleRequest;
import com.ex.identity.dto.response.RoleResponse;
import com.ex.identity.mapper.RoleMapper;
import com.ex.identity.repository.PermissionRepository;
import com.ex.identity.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request){
        var role = roleMapper.toRole(request);
        var permission = permissionRepository.findAllById(request.getPermission());
        role.setPermissions(new HashSet<>(permission));

        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }
    public List<RoleResponse> getAll(){
        var roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    };
    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
