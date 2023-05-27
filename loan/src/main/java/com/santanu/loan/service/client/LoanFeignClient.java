package com.santanu.loan.service.client;

import com.santanu.loan.model.Customer;
import com.santanu.loan.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("loan")
public interface LoanFeignClient {
    @PostMapping(value = "myloan", consumes = "application/json")
    List<Loan> getLoanDetails(@RequestBody Customer customer);
}
