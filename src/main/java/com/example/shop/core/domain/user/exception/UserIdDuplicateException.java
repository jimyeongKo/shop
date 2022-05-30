package com.example.shop.core.domain.user.exception;

import com.example.shop.core.global.error.ErrorCode;
import com.example.shop.core.global.error.InvalidValueException;

public class UserIdDuplicateException extends InvalidValueException {
    public UserIdDuplicateException(String value) {
        super(value, ErrorCode.USERID_DUPLICATION);
    }
}
