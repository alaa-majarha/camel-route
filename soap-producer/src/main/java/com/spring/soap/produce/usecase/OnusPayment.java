package com.spring.soap.produce.usecase;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.MakePaymentResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@NoArgsConstructor  //todo change when impl
@Service
public class OnusPayment {
    public MakePaymentResponse invoke(MakePaymentRequest request){
//        Account payerAccount=paymentRepository.findById(request.getPayerAccount());
//        Account beneficiaryAccount=paymentRepository.findById(request.getBeneficiaryAccount());
//        payerAccount.setBalance(payerAccount.getBalance().plus(request.getAmount()));
        log.info("received onus payment request");
        MakePaymentResponse response= new MakePaymentResponse();
        response.setStatus("success");
        return response;

    }
}
