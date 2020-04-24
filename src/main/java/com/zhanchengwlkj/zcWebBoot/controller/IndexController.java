package com.zhanchengwlkj.zcWebBoot.controller;

import com.zhanchengwlkj.zcWebBoot.utils.LogUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/home")
    public String home(){
        LogUtil.d("home","首页");
        return "home/home";
    }
}
