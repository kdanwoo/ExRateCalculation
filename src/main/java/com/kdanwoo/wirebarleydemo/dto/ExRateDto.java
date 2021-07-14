package com.kdanwoo.wirebarleydemo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

public class ExRateDto {

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RetrieveReq{
        private String currencies;
    }

    @Getter
    public static class ResponseReq{
        private Boolean success;
        private String terms;
        private String privacy;
        private Long timestamp;
        private String source;
        private Object quotes;

    }


}
