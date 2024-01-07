package com.tylphe.microservice2.repository;

import com.tylphe.microservice2.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(Integer orderId);
}
