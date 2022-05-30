package com.example.shop.core.domain.user.exception;

import com.example.shop.core.global.error.ErrorCode;
import com.example.shop.core.global.error.InvalidValueException;

public class NotMyEntityException extends InvalidValueException {

    public NotMyEntityException(String value) {
        super(value, ErrorCode.NOT_MY_ENTITY);
    }
}
