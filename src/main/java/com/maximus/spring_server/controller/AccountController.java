package com.maximus.spring_server.controller;

import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @RequestMapping(value = "/account/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody Account account) throws Exception {
        try {
            return new ResponseEntity<>(accountService.saveUser(account), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(accountService.saveUser(account),HttpStatus.BAD_REQUEST);
        }


    }


}
