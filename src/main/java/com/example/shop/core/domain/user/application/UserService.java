package com.example.shop.core.domain.user.application;

import com.example.shop.core.domain.user.domain.User;
import com.example.shop.core.domain.user.dto.TokenResponse;
import com.example.shop.core.domain.user.persistence.UserRepository;
import com.example.shop.core.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final
    UserRepository repository;

    // 자기 정보 불러오기(토큰 리프레쉬용)
    public TokenResponse me(User user) {
        User me = repository.findById(user.getId()).orElseThrow();

        String token = jwtTokenProvider.createToken(String.valueOf(me.getId()), me.getRoles());

        return new TokenResponse(token, me);
    }
}
