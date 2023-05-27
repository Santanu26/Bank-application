package com.santanu.account.controller;


import com.santanu.account.exception.NotFoundException;
import com.santanu.account.model.Account;
import com.santanu.account.model.Customer;
import com.santanu.account.model.CustomerDetails;
import com.santanu.account.service.AccountService;
import com.santanu.account.service.CustomerService;
import com.santanu.account.service.client.CardFeignClient;
import com.santanu.account.service.client.LoanFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final AccountService accountService;
    private final CustomerService customerService;
    private final LoanFeignClient loanFeignClient;

    private final CardFeignClient cardFeignClient;
    @GetMapping("/myCustomerDetails/{id}")
    public CustomerDetails getCustomerDetails(@PathVariable int id) {
        Account account = accountService.findByCustomerId(id)
                .orElseThrow(() -> new NotFoundException("Account not found for customer: " + id));

        return CustomerDetails.builder()
                .account(account)
                .cards(cardFeignClient.getCardDetails(id))
                .loans(loanFeignClient.getLoanDetails(id))
                .build();
    }
}
