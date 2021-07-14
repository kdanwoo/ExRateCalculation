package com.kdanwoo.wirebarleydemo.enums;

public enum Country {

    KOREA("한국(KRW)","100"),
    JAPAN("일본(JPY)","200"),
    PHILIP("필리핀(PHP)","300");

    private final String name;
    private final String code;

    Country(final String name, final String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
