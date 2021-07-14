package com.kdanwoo.wirebarleydemo.service.impl;

import com.kdanwoo.wirebarleydemo.service.ExRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExRateServiceImpl implements ExRateService {

    private final RestTemplate restTemplate;

    @Value("${currency.endPoint}")
    private String BASE_URL;

    @Value("${currency.accessKey}")
    private String ACCESS_KEY;


    @Override
    public String retrieveExRate() {
        return null;
    }
}
