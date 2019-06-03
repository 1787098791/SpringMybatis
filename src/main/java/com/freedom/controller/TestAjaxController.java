package com.freedom.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.freedom.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAjaxController {
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "getDataJsonp",method = RequestMethod.GET)
    public Object getDataJsonp(String callback){//此处与前端jsonp属性一致
        System.out.println("inner getDataJsonp");
        System.out.println(callback);
        Person person = new Person("小明", 20);
        //注意返回值类型应该为JSONPObject所封装
        JSONPObject jsonpObject = new JSONPObject(callback,person);
        return jsonpObject;
    }

}
