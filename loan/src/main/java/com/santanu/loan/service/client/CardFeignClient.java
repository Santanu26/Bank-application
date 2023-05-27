package com.santanu.loan.service.client;

import com.santanu.loan.model.Card;
import com.santanu.loan.model.Customer;
import com.santanu.loan.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("card")
public interface CardFeignClient {
    @PostMapping(value = "myCard", consumes = "application/json")
    List<Card> getCardDetails(@RequestBody Customer customer);
}
