package com.project.jee.jeedarras.dto;

import com.project.jee.jeedarras.enums.UserRole;

import lombok.Data;

@Data

public class AuthenticationResponse {

    private String jwt;
    private UserRole userRole;
    private Long userId;
}
