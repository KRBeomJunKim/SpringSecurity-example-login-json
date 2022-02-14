package com.example.springbootsecurityjsonexample.web.account.controller;

import com.example.springbootsecurityjsonexample.domain.entity.Account;
import com.example.springbootsecurityjsonexample.security.dto.UsernamePasswordDto;
import com.example.springbootsecurityjsonexample.domain.service.AccountService;
import com.example.springbootsecurityjsonexample.security.dto.IdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/sign-up")
    public ResponseEntity<IdDto> signUp(@RequestBody UsernamePasswordDto usernamePasswordDto) {
        String username = usernamePasswordDto.getUsername();
        String password = usernamePasswordDto.getPassword();
        String role = "ROLE_USER";

        Account account = new Account(username, passwordEncoder.encode(password), role);
        accountService.save(account);

        return ResponseEntity.ok(new IdDto(account.getId()));
    }
}
