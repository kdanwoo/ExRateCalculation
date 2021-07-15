package com.kdanwoo.wirebarleydemo.controller;

import com.kdanwoo.wirebarleydemo.dto.ApiBaseRes;
import com.kdanwoo.wirebarleydemo.dto.ExRateDto;
import com.kdanwoo.wirebarleydemo.service.ExRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ExRateService exRateService;

    @RequestMapping(value = "/v1/exrate", method = RequestMethod.GET)
    public ResponseEntity<ApiBaseRes<Double>> getLiveCurrency(@RequestParam(value="key",required = true) final String key){
        ApiBaseRes<Double> response = new ApiBaseRes<>(exRateService.retrieveExRate(key));
        response.success();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
