package com.kdanwoo.wirebarleydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView mainView() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main"); //화면 View설정

        return mv;
    }
}
