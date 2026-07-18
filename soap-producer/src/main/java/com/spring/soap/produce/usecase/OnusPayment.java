package com.spring.soap.produce.usecase;

import com.spring.soap.produce.MakePaymentRequest;
import com.spring.soap.produce.MakePaymentResponse;
import com.spring.soap.produce.entity.AccountEntity;
import com.spring.soap.produce.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
public class OnusPayment {
    private final AccountRepository accountRepository;

    public OnusPayment(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public MakePaymentResponse invoke(MakePaymentRequest request) {
        Optional<AccountEntity> payerAccount = accountRepository.findByAccountNumber(request.getPayerAccount());
        Optional<AccountEntity> beneficiaryAccount = accountRepository.findByAccountNumber(request.getBeneficiaryAccount());
        AccountEntity beneficiary = beneficiaryAccount.get();

        beneficiary.setBalance(
                beneficiary.getBalance().add(BigDecimal.valueOf(request.getAmount()))
        );
        AccountEntity payer = payerAccount.get();

        payer.setBalance(
                payer.getBalance().subtract(BigDecimal.valueOf(request.getAmount()))
        );
        accountRepository.save(payerAccount.get());
        accountRepository.save(beneficiaryAccount.get());
        log.info("received onus payment request");
        MakePaymentResponse response = new MakePaymentResponse();
        response.setStatus("success");
        return response;

    }
}
