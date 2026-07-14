package com.spring.soap.produce.camel.route.payment;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FromDirectToWaitingPaymentQueue extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:payment")
                .log("Received payment from direct")
                .marshal().json()
                .to("jms:queue:WaitingPayment");
    }
}
