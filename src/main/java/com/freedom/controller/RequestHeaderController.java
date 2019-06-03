package com.freedom.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.Date;

/**
 * Created by DELL on 2019/5/27.
 */
@Controller
public class RequestHeaderController {

    @RequestMapping("getHeaderValue")
    public Object getHeaderValue(@RequestHeader(required = true,value = "Host")String host){
        return host;
    }

    @ResponseBody
    @RequestMapping("fileUpload")
    public String fileUpload (HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) throws IOException, IOException {
        long startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="E:/"+new Date().getTime()+file.getOriginalFilename();
        File newFile=new File(path);
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "upload success";
    }

    @RequestMapping("/testDownload")
    public ResponseEntity<byte[]> download() throws IOException {
        //创建文件
        File file = new File("E://1558924948589qny.jpg");
        byte[] body = null;
        //创建输入流(从硬盘读取数据)
        InputStream is = new FileInputStream(file);
        //创建字节数组并指定长度
        body = new byte[is.available()];
        //将数据从输入流导到输出流
        is.read(body);
        //创建响应头并设置指定值
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置HTTP响应状态。
        HttpStatus statusCode = HttpStatus.OK;
        //创建响应实体对象
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @ResponseBody
    @RequestMapping("getRequestEncode")
    public String getRequestEncode(@RequestParam String name) throws UnsupportedEncodingException {
         name = URLDecoder.decode(name,"utf-8");
        System.out.println("1:"+name);
//        name = new String(name.getBytes(),"UTF-8");
//        System.out.println("2:"+name);
        return name;
    }
    @ResponseBody
    @RequestMapping("test")
    public Object run(){
        return "helleo";
    }



}
