package com.maximus.spring_server.domain.value;

import lombok.Getter;

@Getter
public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


}
