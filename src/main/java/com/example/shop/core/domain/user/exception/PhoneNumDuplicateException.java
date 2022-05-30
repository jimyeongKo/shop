package com.example.shop.core.domain.user.exception;

import com.example.shop.core.global.error.ErrorCode;
import com.example.shop.core.global.error.InvalidValueException;

public class PhoneNumDuplicateException extends InvalidValueException {
    public PhoneNumDuplicateException(String value) {
        super(value, ErrorCode.PHONENUM_DUPLICATION);
    }
}
