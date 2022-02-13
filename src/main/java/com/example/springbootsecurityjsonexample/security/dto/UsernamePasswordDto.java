package com.example.springbootsecurityjsonexample.security.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernamePasswordDto {

    private String username;
    private String password;
}
