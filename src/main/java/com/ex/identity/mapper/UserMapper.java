package com.ex.identity.mapper;

import com.ex.identity.dto.request.UserCreation;
import com.ex.identity.dto.request.UserUpdate;
import com.ex.identity.dto.response.UserResponse;
import com.ex.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserCreation userCreation);
    @Mapping(target ="roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdate request);
}
