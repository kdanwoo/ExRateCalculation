package com.kdanwoo.wirebarleydemo.service.impl;

import com.kdanwoo.wirebarleydemo.constant.Const;
import com.kdanwoo.wirebarleydemo.constant.ErrorCode;
import com.kdanwoo.wirebarleydemo.enums.Country;
import com.kdanwoo.wirebarleydemo.exception.CustomException;
import com.kdanwoo.wirebarleydemo.service.ExRateService;
import com.kdanwoo.wirebarleydemo.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

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

    private boolean flag = false; //예외처리 기준


    @Override
    public double retrieveExRate(String key) {

        JSONObject res = null;

        for(Country country : Country.values()){
            if(key.equals(country.getName())){
                flag = true;
            }
        }

        if(!flag){
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("access_key",ACCESS_KEY);
        params.add("currencies", key);
        params.add("source", Const.SOURCE);
        params.add("format", Const.FORMAT);


        try {
            res = WebClient.create(BASE_URL).get()
                    .uri(uriBuilder ->
                            uriBuilder.path(ENDPOINT)
                                    .queryParams(params).build()
                    ).retrieve().bodyToMono(JSONObject.class)
                    .block();
        }catch (WebClientException e){
            log.error("##### WebClient error, url = {}", BASE_URL+"ENDPOINT", e);
        }

        Map<String, Object> result = new HashMap<>();
        result = null;
        String keyValue = null;
        double realtimeCur = 0;

        try{
            if (res != null) {
                result = (Map<String, Object>) JsonUtil.getMapFromJsonObject(res).get("quotes");
                Set set = result.keySet();
                Iterator iterator = set.iterator();
                while(iterator.hasNext()){
                    keyValue = (String)iterator.next();
                }

                realtimeCur = Double.parseDouble(String.valueOf(result.get(keyValue)));
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new CustomException(ErrorCode.JSONOBJECT_PROCESSING_ERROR);
        }

        return realtimeCur;

    }


}
