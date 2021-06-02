package com.maximus.spring_server.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "account")
public class Account {

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public void save() {
        checkUser(username);
        checkPassword(password);
    }

    private void checkPassword(String password) {
        if (password.isEmpty()) throw new IllegalArgumentException("no password");
    }

    private void checkUser(String username) {
        if (username.isEmpty()) throw new IllegalArgumentException("!!!");

    }

}
