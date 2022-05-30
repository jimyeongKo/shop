package com.example.shop.core.domain.user.api;

import com.example.shop.core.domain.user.application.LoginService;
import com.example.shop.core.domain.user.dto.LoginRequest;
import com.example.shop.core.domain.user.dto.TokenResponse;
import com.example.shop.core.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("login")
public class LoginApi {

    private final LoginService  service;

    @PostMapping
    public ApiResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.login(request));

    }
}
