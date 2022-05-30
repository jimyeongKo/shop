package com.example.shop.core.domain.user.api;

import com.example.shop.core.domain.user.application.RegisterService;
import com.example.shop.core.domain.user.dto.UserRequest;
import com.example.shop.core.domain.user.dto.UserResponse;
import com.example.shop.core.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("register")
public class RegisterApi {

    private final RegisterService service;

    @PostMapping
    public ApiResponse<UserResponse> register(@RequestBody UserRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.register(request));
    }
}
