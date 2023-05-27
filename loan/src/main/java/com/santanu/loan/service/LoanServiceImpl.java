package com.santanu.loan.service;

import com.santanu.loan.model.Loan;
import com.santanu.loan.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public Optional<List<Loan>> findByCustomerIdOrderByStartDtDesc(int customerId) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}
