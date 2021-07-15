package com.kdanwoo.wirebarleydemo.enums;

public enum Country {

    KRW("KRW","100"),
    JPY("JPY","200"),
    PHP("PHP","300");

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
