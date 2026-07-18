package com.spring.soap.consume;


import com.spring.soap.produce.GetAccountInfoRequest;
import com.spring.soap.produce.GetAccountInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class BankSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public BankSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public GetAccountInfoResponse getAccount(String accountNumber) {

        GetAccountInfoRequest request =
                new GetAccountInfoRequest();

        request.setAccountNumber(accountNumber);

        return (GetAccountInfoResponse)
                webServiceTemplate.marshalSendAndReceive(
                        "http://localhost:8080/ws",
                        request
                );
    }
}