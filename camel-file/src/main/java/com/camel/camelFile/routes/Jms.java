package com.camel.camelFile.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class Jms extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:input.queue")
                .log("message: ${body}")
                .choice()
                .when(header("requestType").isEqualTo("paymentDetails"))
                .to("jms:payment.details.queue")
                .otherwise()
                .to("jms:others.queue")
                .end()
                .log("end processing");

    }
}
