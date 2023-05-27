package com.santanu.loan.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanNumber;
    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private Date startDt;

    @Column(nullable = false)
    private String loanType;

    @Column(nullable = false)
    private int totalLoan;

    @Column(nullable = false)
    private int amountPaid;

    @Column(nullable = false)
    private int outstandingAmount;

    @Column(nullable = false)
    private String createDt;
}
