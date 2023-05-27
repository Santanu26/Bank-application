package com.santanu.loan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.santanu.loan.config.LoanConfigServer;
import com.santanu.loan.exception.NotFoundException;
import com.santanu.loan.model.Customer;
import com.santanu.loan.model.Loan;
import com.santanu.loan.model.Properties;
import com.santanu.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    private final LoanConfigServer configServer;

    @GetMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody @Validated Customer customer) {
        return loanService.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId()).orElse(null);
    }

    @GetMapping("/myLoans/customer/{id}")
    public List<Loan> getLoansDetails(@PathVariable int id) {
        return loanService.findByCustomerIdOrderByStartDtDesc(id)
                .orElseThrow(()-> new NotFoundException("Loan not found: "+ id));
    }

    @GetMapping("/loan/properties")
    public String getAllProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = Properties.builder()
                .msg(configServer.getMsg())
                .activeBranches(configServer.getActiveBranches())
                .mailDetails(configServer.getMailDetails())
                .buildVersion(configServer.getBuildVersion()).build();

        return objectWriter.writeValueAsString(properties);
    }
}
