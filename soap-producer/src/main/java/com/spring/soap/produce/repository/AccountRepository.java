package com.spring.soap.produce.repository;

import com.spring.soap.produce.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    public Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
