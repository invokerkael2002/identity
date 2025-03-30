package com.ex.identity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionResponse {
    String name;
    private String description;
}
