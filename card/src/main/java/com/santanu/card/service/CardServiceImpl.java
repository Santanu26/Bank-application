package com.santanu.card.service;

import com.santanu.card.model.Card;
import com.santanu.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public Optional<List<Card>> findByCustomerId(int customerId) {
        return cardRepository.findByCustomerId(customerId);
    }
}
