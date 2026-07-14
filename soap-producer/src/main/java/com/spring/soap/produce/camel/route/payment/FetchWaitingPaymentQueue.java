package com.spring.soap.produce.camel.route.payment;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.service.PaymentService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FetchWaitingPaymentQueue extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:WaitingPayment")
                .unmarshal().json(MakePaymentRequest.class)
                .bean(PaymentService.class);
    }
}
