package com.santanu.loan.service;

import com.santanu.loan.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    Optional<List<Loan>> findByCustomerIdOrderByStartDtDesc(int customerId);
}
