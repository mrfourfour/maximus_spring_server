package com.maximus.spring_server.service;

import com.maximus.spring_server.controller.existsUserException;
import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public Account saveUser(Account account) {
        return accountRepository.save(account);
    }
}
