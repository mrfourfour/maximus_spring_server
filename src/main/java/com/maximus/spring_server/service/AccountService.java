package com.maximus.spring_server.service;


import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.dto.AccountSaveDto;
import com.maximus.spring_server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void save(Long id) {
        Account account = accountRepository.findById(id);

        if (account == null) {
            throw new IllegalArgumentException("account not content");
        }
        account.save();

    }
}
