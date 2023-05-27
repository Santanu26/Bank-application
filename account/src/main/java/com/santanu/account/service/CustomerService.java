package com.santanu.account.service;

import com.santanu.account.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findByCustomerId(int customerId);
}
