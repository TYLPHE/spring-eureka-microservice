package com.tylphe.microservice1.respository;

import com.tylphe.microservice1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
