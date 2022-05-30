package com.example.shop.core.domain.user.exception;

import com.example.shop.core.global.error.ErrorCode;
import com.example.shop.core.global.error.InvalidValueException;

public class UserNotFoundException extends InvalidValueException {
    public UserNotFoundException(String value) {
        super(value, ErrorCode.CHECK_USER_INVALID);
    }
}
