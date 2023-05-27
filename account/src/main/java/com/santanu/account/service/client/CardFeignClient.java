package com.santanu.account.service.client;

import com.santanu.account.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("card")
public interface CardFeignClient {
    @GetMapping(value = "/card-details/{id}", consumes = "application/json")
    List<Card> getCardDetails(@PathVariable int id);
}
