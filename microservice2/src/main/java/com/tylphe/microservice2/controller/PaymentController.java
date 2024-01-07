package com.tylphe.microservice2.controller;

import com.tylphe.microservice2.entity.Payment;
import com.tylphe.microservice2.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable("orderId") Integer orderId) {
        return service.findPaymentHistoryByOrderId(orderId);
    }
}
