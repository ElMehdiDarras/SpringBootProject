package com.project.jee.darrasjee.service;

import com.project.jee.darrasjee.domain.CreditCard;
import com.project.jee.darrasjee.domain.User;
import com.project.jee.darrasjee.dto.CreditCardDto;
import com.project.jee.darrasjee.exception.NoCreditCardException;
import com.project.jee.darrasjee.repository.CreditCardRepository;
import com.project.jee.darrasjee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.jee.darrasjee.mapper.CreditCardDtoMapper.mapToCreditCard;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentService {

        private final UserRepository userRepository;
        private final CreditCardRepository creditCardRepository;
        private final LoggedInUser loggedInUser;

        public void addCreditCard(CreditCardDto creditCardDto) {

                log.info("Adding credit card to user");
                User user = loggedInUser.getUser();

                if(user.getCreditCard() != null) {

                        throw new IllegalCallerException("You Already Have Credit Card!");
                }
                CreditCard card = creditCardRepository.save(mapToCreditCard(creditCardDto));
                user.setCreditCard(card);
                card.setUser(user);
                userRepository.save(user);
        }

        public void moneyTransfer(Long moneyAmount) {

                User user = loggedInUser.getUser();

                if(user.getCreditCard() == null) {

                        throw new NoCreditCardException("You Do Not Have Credit Card!");

                } else {

                        log.info("Transfer for the amount of {}", moneyAmount);
                        CreditCard creditCard = user.getCreditCard();
                        creditCard.setAccountBalance(creditCard.getAccountBalance() + moneyAmount);
                        userRepository.save(user);

                }
        }

}
