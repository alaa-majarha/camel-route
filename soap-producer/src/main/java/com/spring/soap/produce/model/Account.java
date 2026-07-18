package com.spring.soap.produce.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Long id;
    private String accountNumber;
    private String name;
    private BigDecimal balance;



}
