package com.kdanwoo.wirebarleydemo.controller;

import com.kdanwoo.wirebarleydemo.enums.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ViewController {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView mainView() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main"); //화면 View설정

        List<String> list = Stream.of(Country.values())
                .map(m-> m.getName())
                .collect(Collectors.toList());

        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("country",list);

        mv.addObject("data",dataMap);

        return mv;
    }
}
