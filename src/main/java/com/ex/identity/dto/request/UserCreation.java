package com.ex.identity.dto.request;

import com.ex.identity.validator.DobConstrain;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserCreation {

    String username;
    String password;
    String firstName;
    String lastName;
    @DobConstrain(min = 18,message = "INVALID_DOB")
    LocalDate dob;

}
