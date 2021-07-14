package com.kdanwoo.wirebarleydemo.service;

import com.kdanwoo.wirebarleydemo.dto.ExRateDto;

public interface ExRateService {
    String retrieveExRate(ExRateDto.RetrieveReq retrieveReq);
}
