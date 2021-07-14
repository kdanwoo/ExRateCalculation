package com.kdanwoo.wirebarleydemo.service;

import com.kdanwoo.wirebarleydemo.dto.ExRateDto;

public interface ExRateService {
    ExRateDto.ResponseReq retrieveExRate(ExRateDto.RetrieveReq retrieveReq);
}
