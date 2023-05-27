package com.santanu.card.service;

import com.santanu.card.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    Optional<List<Card>> findByCustomerId(int customerId);
}
