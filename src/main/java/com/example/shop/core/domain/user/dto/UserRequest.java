package com.example.shop.core.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    private String userId;

    private String password;

    private String userName;

    private String userInfo;

    private String birth;

    private String phoneNum;
}
