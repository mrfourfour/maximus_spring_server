package com.maximus.spring_server.service;

import com.maximus.spring_server.controller.UserException;
import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;


    @Transactional
    public Account saveUser(Account account) {
        if(accountRepository.findByUsername(account.getUsername())!=null) throw new UserException();
        account.save();
        return accountRepository.save(account);
    }
}
