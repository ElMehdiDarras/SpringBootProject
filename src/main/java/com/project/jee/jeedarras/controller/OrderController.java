package com.project.jee.darrasjee.controller;

import com.project.jee.darrasjee.domain.PlacedOrder;
import com.project.jee.darrasjee.dto.AccessKeyDto;
import com.project.jee.darrasjee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<PlacedOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public AccessKeyDto submitOrder(@RequestParam String carPackage, @RequestParam Integer hours) {
        return orderService.submitOrder(carPackage, hours);
    }

}
