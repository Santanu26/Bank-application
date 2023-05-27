package com.santanu.card.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.santanu.card.config.CardConfigServer;
import com.santanu.card.exception.NotFoundException;
import com.santanu.card.model.Card;
import com.santanu.card.model.Customer;
import com.santanu.card.model.Properties;
import com.santanu.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    private final CardConfigServer configServer;

    @GetMapping("/card-details")
    public List<Card> getCardDetails(@RequestBody @Validated Customer customer) {
        return cardService.findByCustomerId(customer.getCustomerId())
                .orElseThrow(()-> new NotFoundException("Card not found for the customer: "+ customer));
    }

    @GetMapping("/card-details/{id}")
    public List<Card> getCardDetails(@PathVariable int id) {
        return cardService.findByCustomerId(id)
                .orElseThrow(()-> new NotFoundException("Card not found for the id: "+ id));
    }

    @GetMapping("/card/properties")
    public String getAllCardProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = Properties.builder()
                .msg(configServer.getMsg())
                .buildVersion(configServer.getBuildVersion())
                .activeBranches(configServer.getActiveBranches())
                .mailDetails(configServer.getMailDetails())
                .build();
        return objectWriter.writeValueAsString(properties);
    }
}
