package com.project.jee.darrasjee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private String email;
        private Integer phone;

}
