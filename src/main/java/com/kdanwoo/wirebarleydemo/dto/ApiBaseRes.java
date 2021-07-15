package com.kdanwoo.wirebarleydemo.dto;

import com.kdanwoo.wirebarleydemo.constant.Const;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiBaseRes<T> {
    private String responseCode;
    private String responseMessage;
    private T result;

    public ApiBaseRes(T result) {
        this.result = result;
    }

    public void success(String msg) {
        if (msg != null && msg.length() > 0) {
            this.responseCode = Const.API_SUCCESS_CODE;
            this.responseMessage = msg;
        } else {
            success();
        }
    }

    public void success() {
        this.responseCode = Const.API_SUCCESS_CODE;
        if (this.responseMessage == null || (this.responseMessage).trim().length() == 0) {
            this.responseMessage = Const.API_SUCCESS_MSG;
        }
    }

    public void fail(String msg) {
        if (msg != null && msg.length() > 0) {
            this.responseCode = Const.API_FAIL_CODE;
            this.responseMessage = msg;
        } else {
            fail();
        }
    }

    public void fail(String msg, String code) {
        if (msg != null && msg.length() > 0) {
            this.responseCode = code;
            this.responseMessage = msg;
        } else {
            fail();
        }
    }

    public void fail() {
        this.responseCode = Const.API_FAIL_CODE;
        if (this.responseMessage == null || (this.responseMessage).trim().length() == 0) {
            this.responseMessage = Const.API_FAIL_MSG;
        }
    }



}
