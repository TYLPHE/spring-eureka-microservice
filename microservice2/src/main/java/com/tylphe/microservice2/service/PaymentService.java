package com.tylphe.microservice2.service;

import com.tylphe.microservice2.entity.Payment;
import com.tylphe.microservice2.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway (ex. paypal)
        return new Random().nextBoolean() ? "success" : "false";
    }
}
