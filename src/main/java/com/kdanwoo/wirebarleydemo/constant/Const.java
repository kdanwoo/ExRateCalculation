package com.kdanwoo.wirebarleydemo.constant;

import org.springframework.stereotype.Component;

@Component(value = "Const")
public class Const {

    public static final String API_SUCCESS_CODE = "000";
    public static final String API_FAIL_CODE = "999";
    public static final String API_SUCCESS_MSG = "SUCCESS";
    public static final String API_FAIL_MSG = "FAIL";
    public static final String FORMAT = "1"; //format 기준
    public static final String SOURCE = "USD"; //달러 기준

}
