package com.project.jee.darrasjee.controller;

import com.project.jee.darrasjee.domain.Car;
import com.project.jee.darrasjee.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

        private final DeliveryService deliveryService;

        @PostMapping("/delivery")
        public Car pickUpTheCar(@RequestParam Long carId) {
                return deliveryService.pickUpTheCar(carId);
        }

}
