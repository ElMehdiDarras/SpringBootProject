package com.project.jee.jeedarras.dto;
import com.project.jee.jeedarras.enums.UserRole;

import lombok.Data;


@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
