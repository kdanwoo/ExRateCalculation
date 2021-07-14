package com.kdanwoo.wirebarleydemo.service.impl;

import com.kdanwoo.wirebarleydemo.dto.ExRateDto;
import com.kdanwoo.wirebarleydemo.service.ExRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExRateServiceImpl implements ExRateService {

    private final RestTemplate restTemplate;

    @Value("${currency.url}")
    private String BASE_URL;

    @Value("${currency.endPoint}")
    private String ENDPOINT;

    @Value("${currency.accessKey}")
    private String ACCESS_KEY;

    private static final String format = "1";
    private static final String source = "USD";


    @Override
    public ExRateDto.ResponseReq retrieveExRate(ExRateDto.RetrieveReq retrieveReq) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("currencies", retrieveReq.getCurrencies());
        params.add("source", source);
        params.add("format", format);

        ExRateDto.ResponseReq res = WebClient.create(BASE_URL).get()
                .uri(uriBuilder ->
                        uriBuilder.path(ENDPOINT)
                                .queryParams(params).build()
                ).retrieve().bodyToMono(ExRateDto.ResponseReq.class)
                .block();
        return res;
    }
}
