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
    public Map<String, Object> getLiveCurrency(@RequestParam(value="key") final String key){
        JSONObject res = exRateService.retrieveExRate(key);
        Map<String, Object> result = new HashMap<>();

        result.put("res",res.get("quotes"));

        return result;
    }


}
