package com.spring.soap.produce.webservice;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.MakePaymentResponse;
import org.apache.camel.ProducerTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndpoint {
    private final ProducerTemplate producerTemplate;

    public PaymentEndpoint(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    private static final String NAMESPACE =
            "http://bmct.com/makePayment";

    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "MakePaymentRequest")
    @ResponsePayload
    public MakePaymentResponse makePayment(
            @RequestPayload MakePaymentRequest request) {

        return producerTemplate.requestBody(
                "direct:payment",
                request,
                MakePaymentResponse.class);
    }
}