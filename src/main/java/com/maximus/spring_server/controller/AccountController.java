package com.maximus.spring_server.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/account/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Account> signUp(@RequestBody Account account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            accountService.saveUser(account);
            return new HttpEntity<Account>(account,httpHeaders);
        } catch () {
            return account;
        }
    }
}
