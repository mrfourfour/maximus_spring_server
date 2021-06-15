package com.maximus.spring_server.service;

import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Account saveUser(Account account) throws Exception {
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            throw new Exception();

        }
            account.validationUser();
            return accountRepository.save(account);

    }
}
