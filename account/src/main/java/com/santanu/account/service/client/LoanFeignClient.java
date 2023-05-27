package com.santanu.account.service.client;

import com.santanu.account.model.Customer;
import com.santanu.account.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("loan")
public interface LoanFeignClient {
    @GetMapping(value = "myLoans/customer/{id}", consumes = "application/json")
    List<Loan> getLoanDetails(@PathVariable int id);
}
