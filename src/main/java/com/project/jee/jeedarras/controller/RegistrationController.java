package com.project.jee.darrasjee.controller;

import com.project.jee.darrasjee.dto.UserInDto;
import com.project.jee.darrasjee.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

        private final RegistrationService registrationService;

        @PostMapping("/registration")
        public void registerUser(@RequestBody UserInDto userInDto) {
                registrationService.registerUser(userInDto);
        }

}
