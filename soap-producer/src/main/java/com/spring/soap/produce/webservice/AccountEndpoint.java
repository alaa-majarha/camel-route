package com.spring.soap.produce.webservice;

import com.spring.soap.produce.GetAccountInfoRequest;
import com.spring.soap.produce.GetAccountInfoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
public class AccountEndpoint {

    private static final String NAMESPACE =
            "http://example.com/account";


    @PayloadRoot(
            namespace = NAMESPACE,
            localPart = "GetAccountInfoRequest"
    )
    @ResponsePayload
    public GetAccountInfoResponse getAccountInfo(
            @RequestPayload GetAccountInfoRequest request) {


        System.out.println(
                "Account number: "
                        + request.getAccountNumber()
        );


        GetAccountInfoResponse response =
                new GetAccountInfoResponse();


        response.setCustomerName("John Smith");
        response.setBalance(
                new BigDecimal("2500")
        );
        response.setCurrency("USD");
        response.setStatus("ACTIVE");


        return response;
    }
}