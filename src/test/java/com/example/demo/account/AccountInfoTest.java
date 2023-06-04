package com.example.demo.account;

import com.example.demo.account.controller.form.AccountInfoForm;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.service.AccountService;
import com.example.demo.account.service.AccountServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AccountInfoTest {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @Test
    @DisplayName("로그인 된 회원 정보를 확인합니다.")
    void accountInfo(){
//        Account account = new Account("asdf","1111","aad7dfaa-3434-468b-89f6-169e2609253d");
//        accountRepository.save(account);

        final UUID userToken = UUID.fromString("aad7dfaa-3434-468b-89f6-169e2609253d");

        AccountInfoForm accountInfoForm = new AccountInfoForm(userToken);
        Account checkAccountInfo = accountService.accountInfo(accountInfoForm);


        assertNotNull(checkAccountInfo.getId());
        assertNotNull(checkAccountInfo.getEmail());
        assertNotNull(checkAccountInfo.getPassword());
        assertNotNull(checkAccountInfo.getUserToken());



    }

}
