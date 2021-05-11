package com.maximus.spring_server.controller;


import com.maximus.spring_server.dto.AccountSaveDto;
import com.maximus.spring_server.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account/signup")
    public Long save(@RequestBody AccountSaveDto accountSaveDto) {
        return accountService.save(accountSaveDto);
    }

}
