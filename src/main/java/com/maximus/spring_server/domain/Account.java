package com.maximus.spring_server.domain;

import com.maximus.spring_server.repository.AccountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
@Getter
@Table(name = "account")
public class Account {

    private final AccountRepository accountRepository;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public void save(Account account){
        account.checkExistUser(account.getUsername());
    }

    private void checkExistUser(String username) {
        if (accountRepository.existsById(username) || username.isEmpty()) throw new IllegalArgumentException("!!!");

    }

}
