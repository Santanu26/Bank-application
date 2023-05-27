package com.santanu.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private long accountNumber;
    @Column(nullable = false)
    private int customerId;
    @Column(nullable = false)
    private String accountType;
    @Column(nullable = false)
    private String branchAddress;
    private LocalDate createDt;
}
