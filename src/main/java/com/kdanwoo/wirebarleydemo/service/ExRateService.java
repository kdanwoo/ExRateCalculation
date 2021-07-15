package com.kdanwoo.wirebarleydemo.service;

import org.json.simple.JSONObject;

public interface ExRateService {
    JSONObject retrieveExRate(String key);
}
