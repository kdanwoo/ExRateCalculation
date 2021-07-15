package com.kdanwoo.wirebarleydemo.controller;

import com.kdanwoo.wirebarleydemo.dto.ExRateDto;
import com.kdanwoo.wirebarleydemo.service.ExRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/getcurrency")
@RequiredArgsConstructor
public class ApiController {

    private final ExRateService exRateService;

    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public String getLiveCurrency(@RequestParam(value="key") final String key){
        return exRateService.retrieveExRate(key);
    }


}
