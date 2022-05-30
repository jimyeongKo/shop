package com.example.shop.core.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    @NotNull
    private String userId;

    @NotBlank
    @NotNull
    private String password;
}
