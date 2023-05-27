package com.santanu.account.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(name = "create_dt")
    private LocalDate createDt;
}
