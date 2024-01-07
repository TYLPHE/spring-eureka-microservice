package com.tylphe.microservice1.service;

import com.tylphe.microservice1.common.PaymentDto;
import com.tylphe.microservice1.common.TransactionRequest;
import com.tylphe.microservice1.common.TransactionResponse;
import com.tylphe.microservice1.entity.Order;
import com.tylphe.microservice1.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
//         PaymentDto paymentDto = request.getPaymentDto();
        // In order to fix error of null value from above line, I just created a new DTO
        PaymentDto paymentDto = new PaymentDto();
        System.out.println("paymentDto = " + paymentDto);
        paymentDto.setOrderId(order.getId());
        paymentDto.setAmount(order.getPrice());

        // Rest call
        // Hard coding the localhost URL until we set up Eureka, then use the Eureka reference
//        PaymentDto paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/doPayment", paymentDto, PaymentDto.class);
        PaymentDto paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", paymentDto, PaymentDto.class);

        assert paymentResponse != null;
        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "There is a failure in payment api, order added to cart";

        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }
}
