package com.santanu.account.service;

import com.santanu.account.model.Customer;
import com.santanu.account.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findByCustomerId(int customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
