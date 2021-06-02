package com.maximus.spring_server.controller;

import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/account/signup", method = RequestMethod.POST)
    public Account signUp(@RequestBody Account account) {
            try{
                accountService.saveUser(account);
            }catch (UserException e){
                e.printStackTrace();
            }
            return account;
    }
}
