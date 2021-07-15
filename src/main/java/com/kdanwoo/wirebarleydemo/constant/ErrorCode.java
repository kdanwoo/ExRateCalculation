package com.kdanwoo.wirebarleydemo.constant;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "0402", "Invalid Request Data"),
    JSONOBJECT_PROCESSING_ERROR(HttpStatus.BAD_REQUEST, "0403","JSONObject Processing Error");

    private final HttpStatus status;
    private final String code;
    private final String message;


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    ErrorCode(final HttpStatus status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
