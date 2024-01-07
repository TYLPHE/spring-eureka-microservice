package com.tylphe.microservice1.common;

import com.tylphe.microservice1.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private String transactionId;
    private Double amount;
    private String message;
}
