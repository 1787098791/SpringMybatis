package com.freedom.controller;

import com.freedom.Vo.UserInfoVo;
import com.freedom.pojo.UserInfo;
import com.freedom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserListController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("selectAllUserListCon")
    public ModelAndView selectAllUserListCon(HttpSession session,ModelAndView modelAndView){
        List<UserInfo> userInfoList = userInfoService.selectAllUserinfo();
        modelAndView.setViewName("userlist.html");
        /*modelAndView.addObject("myflag","true");
        modelAndView.addObject("userlist",userInfoList);*/
        session.setAttribute("myflag","true");
        session.setAttribute("userlist",userInfoList);
        System.out.println(modelAndView.getModelMap());
        System.out.println(userInfoList);
        return modelAndView;
    }

    @RequestMapping("deleteuser")
    public ModelAndView deleteuser(ModelAndView modelAndView, @RequestParam int userid){
        int i = userInfoService.deleteUserByID(userid);
            if (i==0){
                modelAndView.setViewName("userlist.html");
                return modelAndView;
            }
           modelAndView.setViewName("forward:/selectAllUserListCon");
        return modelAndView;
    }


    @RequestMapping("muSelectUserCon")
    public ModelAndView mhselect(HttpSession session, UserInfoVo userInfoVo, ModelAndView modelAndView){
        //System.out.println(userInfoVo);
        String info = userInfoVo.getInfo();
        info="%"+info+"%";
        userInfoVo.setInfo(info);
        List<UserInfo> userInfoList = userInfoService.mhselect(userInfoVo);
        System.out.println(userInfoList);
        session.setAttribute("myflag","false");
        session.setAttribute("userlist",userInfoList);
        modelAndView.setViewName("userlist.html");
        return  modelAndView;
    }
}
