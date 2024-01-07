package com.tylphe.microservice1.controller;

import com.tylphe.microservice1.common.PaymentDto;
import com.tylphe.microservice1.common.TransactionRequest;
import com.tylphe.microservice1.common.TransactionResponse;
import com.tylphe.microservice1.entity.Order;
import com.tylphe.microservice1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    public final OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

        // To associate with other microservice, do a REST call to payment and pass order id
        return service.saveOrder(request);
    }
}
