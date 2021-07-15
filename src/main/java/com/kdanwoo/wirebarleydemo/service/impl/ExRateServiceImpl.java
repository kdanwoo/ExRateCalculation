package com.kdanwoo.wirebarleydemo.service.impl;

import com.kdanwoo.wirebarleydemo.service.ExRateService;
import com.kdanwoo.wirebarleydemo.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExRateServiceImpl implements ExRateService {

    @Value("${currency.url}")
    private String BASE_URL;

    @Value("${currency.endPoint}")
    private String ENDPOINT;

    @Value("${currency.accessKey}")
    private String ACCESS_KEY;

    private static final String format = "1";
    private static final String source = "USD";


    @Override
    public double retrieveExRate(String key) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("access_key",ACCESS_KEY);
        params.add("currencies", key);
        params.add("source", source);
        params.add("format", format);

        JSONObject res = WebClient.create(BASE_URL).get()
                .uri(uriBuilder ->
                        uriBuilder.path(ENDPOINT)
                                .queryParams(params).build()
                ).retrieve().bodyToMono(JSONObject.class)
                .block();

        Map<String, Object> result = new HashMap<>();
        result = null;
        String keyValue = null;
        double realtimeCur = 0;

        if (res != null) {
            result = (Map<String, Object>) JsonUtil.getMapFromJsonObject(res).get("quotes");
            Set set = result.keySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                keyValue = (String)iterator.next();
            }

            realtimeCur = Double.parseDouble(String.valueOf(result.get(keyValue)));
        }
        return realtimeCur;

    }


}
