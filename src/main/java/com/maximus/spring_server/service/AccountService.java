package com.maximus.spring_server.service;


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
public class AccountService extends RuntimeException {

    private final AccountRepository accountRepository;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "잘못된 접근입니다.")
    public class UrlNotFoundException extends RuntimeException {
    }

    @Transactional
    public Long save(AccountSaveDto accountSaveDto) {
        String username = accountSaveDto.getUsername();
        boolean anyMatch = accountRepository.findAll()
                .stream()
                .limit(1)
                .anyMatch((s) -> s.getUsername().equals(username));
        if (anyMatch == true) {
            throw new UrlNotFoundException();
        }
        return accountRepository.save(accountSaveDto.toEntity()).getId();


    }
}
