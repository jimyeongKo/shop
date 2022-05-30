package com.example.shop.core.domain.user.application;

import com.example.shop.core.domain.user.domain.User;
import com.example.shop.core.domain.user.dto.LoginRequest;
import com.example.shop.core.domain.user.dto.TokenResponse;
import com.example.shop.core.domain.user.exception.PasswordNotMatchException;
import com.example.shop.core.domain.user.exception.UserNotFoundException;
import com.example.shop.core.domain.user.persistence.UserRepository;
import com.example.shop.core.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class LoginService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public TokenResponse login(LoginRequest request) {
        User user = repository.findByUserId(request.getUserId());

        if (user == null) throw new UserNotFoundException(request.getUserId());

        matchPassword(user.getPassword(), request.getPassword());

        //토큰 발행
        String token = tokenProvider.createToken(String.valueOf(user.getId()), user.getRoles());

        return new TokenResponse(token, user);
    }

    //패스워드가 맞는지 확인
    private void matchPassword(String encodePassword, String password) {
        if (!passwordEncoder.matches(password, encodePassword)) throw new PasswordNotMatchException(password);
    }
}
