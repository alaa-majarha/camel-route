package com.spring.soap.produce.service;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.MakePaymentResponse;
import com.spring.soap.produce.usecase.OffusPayment;
import com.spring.soap.produce.usecase.OnusPayment;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.spring.soap.produce.Constant.BANK_SHORT_NAME;

@Service
@Transactional
public class PaymentService {

    private final OnusPayment onusPayment;
    private final OffusPayment offusPayment;

    public PaymentService(OnusPayment onusPayment, OffusPayment offusPayment) {
        this.onusPayment = onusPayment;
        this.offusPayment = offusPayment;
    }

    public MakePaymentResponse process(
            MakePaymentRequest request) {
        if(Objects.equals(request.getBankShortName(), BANK_SHORT_NAME)){
          return   onusPayment.invoke(request);
        }
        else {
          return   offusPayment.invoke(request);
        }

    }
}