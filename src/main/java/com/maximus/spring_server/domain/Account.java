package com.maximus.spring_server.domain;

import com.maximus.spring_server.domain.value.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Account {
    private Long accountId;
    private User user;

    public Account(Long accountId, User user) {
        this.accountId = accountId;
        this.user = user;
    }

    public void save(Long accountId) {
        verifyExitsUser(accountId);

    }

    private void verifyExitsUser(Long accountId) {
        if (this.accountId == accountId) throw new IllegalArgumentException("no");

    }


}
