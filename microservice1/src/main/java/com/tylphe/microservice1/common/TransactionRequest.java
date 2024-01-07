package com.tylphe.microservice1.common;

import com.tylphe.microservice1.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private PaymentDto paymentDto;
}
