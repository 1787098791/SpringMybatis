package com.freedom.controller;

import com.alibaba.fastjson.JSONArray;
import com.freedom.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TestClient {
    //@ResponseBody
    @RequestMapping("freedom")
    public void freedom(HttpServletRequest httpServletRequest, @RequestBody List<Integer> thelist){

        System.out.println(thelist);
        System.out.println(thelist.size());
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","小明");
        //return map;
    }

    @ResponseBody
    @RequestMapping("cchello")
    public String cchello(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        String string = JSONArray.toJSONString(list);
        String s = HttpClientUtils.doPostJson("http://localhost:8080/freedom", string);
        System.out.println(s);
        return "233";
    }

}
