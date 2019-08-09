package com.freedom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThyController {

    @RequestMapping("testthy")
    public String testThy(ModelMap map){
        map.put("a","111111");

        return "testthy.html";
    }
}
