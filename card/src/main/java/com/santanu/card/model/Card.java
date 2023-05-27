package com.santanu.card.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private int totalLimit;

    @Column(nullable = false)
    private int amountUsed;

    @Column(nullable = false)
    private int availableAmount;

    @Column(nullable = false)
    private Date createDt;
}
