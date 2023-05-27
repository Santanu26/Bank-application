package com.santanu.loan.repository;

import com.santanu.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<List<Loan>> findByCustomerIdOrderByStartDtDesc(int customerId);
}
