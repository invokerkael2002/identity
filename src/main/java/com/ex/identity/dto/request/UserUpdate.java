package com.ex.identity.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserUpdate {

    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<String> roles;
}
