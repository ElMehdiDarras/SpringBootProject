package com.project.jee.darrasjee.mapper;

import com.project.jee.darrasjee.domain.CreditCard;
import com.project.jee.darrasjee.dto.CreditCardDto;
import org.springframework.stereotype.Service;

@Service
public class CreditCardDtoMapper {

    public static CreditCard mapToCreditCard(CreditCardDto creditCardDto) {

        return CreditCard.builder()
                .cardNumber(creditCardDto.getCardNumber())
                .month(creditCardDto.getMonth())
                .year(creditCardDto.getYear())
                .CVV(creditCardDto.getCVV())
                .accountBalance(0L)
                .build();
    }

}
