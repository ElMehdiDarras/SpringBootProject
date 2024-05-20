package com.project.jee.darrasjee.mapper;

import com.project.jee.darrasjee.domain.CreditCard;
import com.project.jee.darrasjee.domain.User;
import com.project.jee.darrasjee.dto.UserInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserInDtoMapper {

        public static final CreditCard CREDIT_CARD = null;

        public static User mapToUser(UserInDto userInDto) {

                return User.builder()
                        .firstName(userInDto.getFirstName())
                        .lastName(userInDto.getLastName())
                        .username(userInDto.getUsername())
                        .password(userInDto.getPassword())
                        .email(userInDto.getEmail())
                        .phone(userInDto.getPhone())
                        .creditCard(CREDIT_CARD)
                        .roles(new ArrayList<>())
                        .build();

        }

}
