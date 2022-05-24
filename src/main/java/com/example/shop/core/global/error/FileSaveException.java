package com.example.shop.core.global.error;

public class FileSaveException extends InvalidValueException{
    public FileSaveException(String value) {
        super(value, ErrorCode.FILE_SAVE_ERROR);
    }
}
