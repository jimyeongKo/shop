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

    private Long team;

    private String userInfo;

    private int birth;

    private String phoneNum;
}
