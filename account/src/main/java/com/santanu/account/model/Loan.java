package com.santanu.account.model;

import lombok.Data;

import java.util.Date;

@Data
public class Loan {
    private int loanNumber;
    private int customerId;

    private Date startDt;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private String createDt;
}
