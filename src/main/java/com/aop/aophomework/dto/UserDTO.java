package com.aop.aophomework.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

}
