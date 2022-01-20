package com.maximus.spring_server.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;

//    @Builder
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }


    public User(Long userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public void ExitUser(List<User> user) throws IllegalArgumentException {
        for (User user1 : user) {
            if (user1.getUsername().equals(this.getUsername())) {
                throw new IllegalArgumentException();
            }
        }

    }
}
