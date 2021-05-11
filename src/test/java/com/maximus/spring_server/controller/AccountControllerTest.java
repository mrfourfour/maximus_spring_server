package com.maximus.spring_server.controller;

import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.dto.AccountSaveDto;
import com.maximus.spring_server.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

    @LocalServerPort
    public int port;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @AfterEach
//    public void refrash(){
//        accountRepository.deleteAll();
//    }


    @Test
    public void data_post() {
        String url = "http://localhost:" + port + "/account/signup";
        String username = "me";
        String password = "1234";

        AccountSaveDto accountSaveDto = AccountSaveDto.builder()
                .username(username)
                .password(password)
                .build();

        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, accountSaveDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        AccountSaveDto accountSaveDto2 = AccountSaveDto.builder()
                .username(username)
                .password(password)
                .build();

        ResponseEntity<Object> responseEntity2 = testRestTemplate.postForEntity(url, accountSaveDto2, Object.class);
        assertThat(responseEntity2.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);


    }
}