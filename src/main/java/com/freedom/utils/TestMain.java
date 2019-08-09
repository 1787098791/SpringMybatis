package com.freedom.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        String string = JSONArray.toJSONString(list);
        String s = HttpClientUtils.doPostJson("http://localhost:8080/freedom", string);
        System.out.println(s);
    }
}
