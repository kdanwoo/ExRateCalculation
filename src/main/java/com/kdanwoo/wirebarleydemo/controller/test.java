package com.kdanwoo.wirebarleydemo.controller;

import com.kdanwoo.wirebarleydemo.enums.Country;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        List<String> list3 = Stream.of(Country.values())
                .map(m-> m.getName())
                .collect(Collectors.toList());
        System.out.println(list3);
    }
}
