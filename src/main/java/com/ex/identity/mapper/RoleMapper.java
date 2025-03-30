package com.ex.identity.mapper;

import com.ex.identity.dto.request.RoleRequest;
import com.ex.identity.dto.response.RoleResponse;
import com.ex.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

}

