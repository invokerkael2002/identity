package com.ex.identity.mapper;

import com.ex.identity.dto.request.PermissionRequest;
import com.ex.identity.dto.response.PermissionResponse;
import com.ex.identity.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission request);
}
