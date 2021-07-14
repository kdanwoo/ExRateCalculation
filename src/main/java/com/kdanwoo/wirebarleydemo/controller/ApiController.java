package com.kdanwoo.wirebarleydemo.controller;

import com.kdanwoo.wirebarleydemo.dto.ExRateDto;
import com.kdanwoo.wirebarleydemo.service.ExRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/live-currency")
@RequiredArgsConstructor
public class ApiController {

    private final ExRateService exRateService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Map<String, Object> getLiveCurrency(@PathVariable("key") final String key){
        ExRateDto.ResponseReq res = exRateService.retrieveExRate(key);
        Map<String, Object> result = new HashMap<>();

        result.put("res",res.getQuotes());

        return result;
    }

}
