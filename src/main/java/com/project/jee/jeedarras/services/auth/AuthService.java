package com.project.jee.jeedarras.services.auth;

import com.project.jee.jeedarras.dto.SignupRequest;
import com.project.jee.jeedarras.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);

}
