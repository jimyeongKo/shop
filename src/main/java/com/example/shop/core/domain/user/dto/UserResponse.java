package com.example.shop.core.domain.user.dto;

import com.example.shop.core.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
    private Long id;

    private String userId;

    private String password;

    private String userName;

    private int birth;

    private String phoneNum;

    public UserResponse(final User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.userName = user.getUsername();
        this.birth = user.getBirth();
        this.phoneNum = user.getPhoneNum();

    }
}
