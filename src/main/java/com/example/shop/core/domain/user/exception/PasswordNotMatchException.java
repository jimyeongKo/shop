package com.example.shop.core.domain.user.exception;

import com.example.shop.core.global.error.ErrorCode;
import com.example.shop.core.global.error.InvalidValueException;

public class PasswordNotMatchException extends InvalidValueException {
    public PasswordNotMatchException(String value) {
        super(value, ErrorCode.PASSWORD_INPUT_INVALID);
    }

}
