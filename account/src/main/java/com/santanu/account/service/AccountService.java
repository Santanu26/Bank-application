package com.santanu.account.service;

import com.santanu.account.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findByCustomerId(int customerId);

    Optional<List<Account>> findAll();
}
