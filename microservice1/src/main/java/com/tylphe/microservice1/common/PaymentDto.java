package com.tylphe.microservice1.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;

    // From microservice1 to link the relationship
    private Integer orderId;
    private Double amount;
}
