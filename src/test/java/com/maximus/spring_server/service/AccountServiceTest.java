package com.maximus.spring_server.service;

import com.maximus.spring_server.domain.Account;
import com.maximus.spring_server.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;


    @AfterEach
    public void tearDown() throws Exception {
        accountRepository.deleteAll();
    }

    @Test
    public void 저장작동테스트() {
        String username = "1234";
        String password = "me2";

        Account account = new Account(username, password);
        //given
        given(accountService.saveUser(account)).willReturn(account);
        //when

        Account account2 = accountService.saveUser(account);
        assertThat(account.getUsername()).isEqualTo(username);
        assertThat(account.getPassword()).isEqualTo(password);

        assertThat(account2.getUsername()).isEqualTo(account.getUsername());
        assertThat(account2.getPassword()).isEqualTo(account.getPassword());

        assertThat(account2.getUsername()).isNotEmpty();
        assertThat(account2.getPassword()).isNotEmpty();

    }
}

