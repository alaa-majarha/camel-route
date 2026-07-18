package com.spring.soap.produce.usecase;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.MakePaymentResponse;
import com.spring.soap.produce.repository.AccountRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@NoArgsConstructor
@Service
public class OffusPayment {


    public MakePaymentResponse invoke(MakePaymentRequest request){

         log.info("received offus payment request");
        MakePaymentResponse response= new MakePaymentResponse();
        response.setStatus("success");
        return response;
    }
}
