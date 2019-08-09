package com.freedom.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freedom.Vo.MenuInfoVo;
import com.freedom.Vo.UserInfoVo;

import com.freedom.mapper.MenuInfoMapper;
import com.freedom.mapper.UserInfoMapper;
import com.freedom.pojo.UserInfo;
import com.freedom.service.UserInfoService;
import com.freedom.service.imp.MenuInfoServiceImp;
import com.freedom.service.imp.UserInfoServiceImp;
import com.freedom.utils.FinalMD5;
import com.freedom.utils.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDemo {
    @Test
    public void test(){
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUSERNAME("白手");
        userInfoVo.setPASSWORD("123456");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserInfoServiceImp bean = applicationContext.getBean(UserInfoServiceImp.class);
       /* UserInfo login = bean.login(userInfoVo);
        System.out.println(login);*/


    }

    @Test
    public void test2(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a","aa");
        map.put("b","bb");
        String string = JSONObject.toJSONString(map);
        System.out.println(string);

        ArrayList<Object> list = new ArrayList<Object>();
        list.add("aa");
        list.add("bb");
        String string1 = JSONObject.toJSONString(list);
        System.out.println(string1);

        /*Object flag=true;
        String string2 = JSONObject.toJSONString(flag);
        System.out.println(string2);
        JSONObject jsonObject = JSONObject.parseObject(string2);
        System.out.println(jsonObject);*/

        String string3 = JSONObject.toJSONString("111");
        System.out.println(string3);
        JSONObject jsonObject1 = JSONObject.parseObject(string3);
        System.out.println(jsonObject1);
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MenuInfoServiceImp bean = applicationContext.getBean(MenuInfoServiceImp.class);
        List<Integer> integers = bean.selectAllParentMenu();
        System.out.println(integers);
    }
    @Test
    public void test4(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MenuInfoMapper bean = applicationContext.getBean(MenuInfoMapper.class);
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        int[] arr=new int[]{2,3,4};
        menuInfoVo.setMenuids(arr);
        menuInfoVo.setRoleid(2);
        int i = bean.insertRoleAndMenu(menuInfoVo);
    }
    @Test
    public void test5(){
        MenuInfoVo menuInfoVo = new MenuInfoVo();
        int[] arr=new int[]{2,3,4};
        menuInfoVo.setMenuids(arr);
        menuInfoVo.setRoleid(2);
        String string = JSONObject.toJSONString(menuInfoVo);
        System.out.println(string);

    }
    @Test
    public void test6() throws JsonProcessingException {
        ArrayList list = new ArrayList();
        String string = JSONArray.toJSONString(list);
        System.out.println(string);
        JSONArray objects = JSONArray.parseArray(string);
        //System.out.println(objects);
        list=null;
        String string1 = JSONObject.toJSONString(list);
       // System.out.println(string1);
       // System.out.println(JSONObject.parseObject(string1));
        //

        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = null;
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String string2 = mapper.writeValueAsString(userInfo);
        System.out.println(string2);

        JSONObject jsonObject = JSONObject.parseObject("");
        System.out.println(jsonObject);

    }
    @Test

        public void doGetTestOne () {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        String string = JSONArray.toJSONString(list);
        String s = HttpClientUtils.doPostJson("http://localhost:8080/freedom", string);
        System.out.println(s);
    }
    @Test
    public void test7(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserInfoServiceImp bean = (UserInfoServiceImp) classPathXmlApplicationContext.getBean(UserInfoService.class);
        UserInfo userInfo = bean.selectUserByID(1);
        System.out.println(userInfo);

    }

}
