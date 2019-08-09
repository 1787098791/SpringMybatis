package com.freedom.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.freedom.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TestAjaxController {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "getDataJsonp",method = RequestMethod.GET)
    public Object getDataJsonp(HttpServletResponse response,HttpSession session, @RequestParam int a, String callback) throws IOException {//此处与前端jsonp属性一致
        System.out.println(a+"2333333");
        System.out.println("inner getDataJsonp");
        //System.out.println(session.getAttribute("user"));
        System.out.println(callback);
        //Person person = new Person("小明", 20);
        //注意返回值类型应该为JSONPObject所封装
        JSONPObject jsonpObject = new JSONPObject(callback,"");
        //response.sendRedirect("/test1");
        return jsonpObject;
    }
@RequestMapping("test1")
    public String test1(){
        return "test1.html";
}
}
