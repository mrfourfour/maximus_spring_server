package com.maximus.spring_server.dto;


import com.maximus.spring_server.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountSaveDto {

    private String username;
    private String password;

    @Builder
    public AccountSaveDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account toEntity(){
        return Account.builder()
                .username(username)
                .password(password)
                .build();

    }
}
