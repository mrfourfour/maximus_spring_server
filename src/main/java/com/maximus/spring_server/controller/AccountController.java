package com.maximus.spring_server.controller;

import com.maximus.spring_server.domain.User;
import com.maximus.spring_server.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private final AccountService accountService;

    @PostMapping("/account/signup")
    public ResponseEntity<User> responseEntity(@RequestBody User user) throws Exception {
        try {
            User user1 = accountService.signup(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(User.builder().userId(user1.getUserId()).username(user1.getUsername()).build());
        } catch (Exception e) {
            logger.info("에러");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(User.builder().build());
        }
    }
}
