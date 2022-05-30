package com.example.shop.core.domain.user.api;

import com.example.shop.core.domain.user.application.UserService;
import com.example.shop.core.domain.user.domain.User;
import com.example.shop.core.domain.user.dto.TokenResponse;
import com.example.shop.core.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserService service;

    @GetMapping("/me")
    public ApiResponse<TokenResponse> me(@AuthenticationPrincipal User user) {
        return new ApiResponse<>(HttpStatus.OK, service.me(user));
    }


}
