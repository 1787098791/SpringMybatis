package com.freedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestThy {
    @RequestMapping("turnto")
    public String turnto(HttpSession session,@RequestParam String username){
       session.setAttribute("info",username);
        return "forward:/turntoB";
    }
    @RequestMapping("turntoB")
    public String turnto(HttpSession session){
        String info =(String) session.getAttribute("info");


        System.out.println(info);
        return "B.html";

    }


}
