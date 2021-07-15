package com.kdanwoo.wirebarleydemo.exception;

import com.kdanwoo.wirebarleydemo.constant.ErrorCode;
import lombok.Getter;

public class CustomException extends RuntimeException{

    @Getter
    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
