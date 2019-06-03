package com.freedom.controller;

import com.alibaba.fastjson.JSONArray;
import com.freedom.Vo.UserInfoVo;
import com.freedom.dto.JDTDto;
import com.freedom.dto.RoleDto;
import com.freedom.pojo.UserInfo;
import com.freedom.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import sun.plugin2.applet.Applet2ClassLoader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;



@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 登录
     * @param userInfoVo
     * @return
     */
    @ResponseBody//restful风格，返回json格式数据
    @RequestMapping("thelogin")
    public Object regist(HttpSession session,@Valid @RequestBody UserInfoVo userInfoVo,BindingResult result){
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("result","error");
        if (result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError :fieldErrors){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            System.out.println(map);
            return map;
        }
        UserInfo userInfo = userInfoService.login(userInfoVo);
        if (userInfo!=null){
            //不为空查到的用户信息入域
            session.setAttribute("userinfo",userInfo);
            map.put("result", "main.html");
            return map;
        }
        map.put("result", "login.html");
        return map;
    }

    /**
     * 注册（增加）用户
     * @param userInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("registCon")
    public Object regist(@Valid @RequestBody UserInfo userInfo,BindingResult result){
        //先验证参数
        HashMap<String, String> map = new HashMap<String, String>();
        if (result.hasErrors()){
            map.put("result","error");
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError:fieldErrors) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return map;
        }

        int i = userInfoService.insertregist(userInfo);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 大条件下模糊条件查询
     * @param userInfoVo
     * @return
     */
    @ResponseBody
    @RequestMapping("muselectCon")
    public Object mhselect(@RequestBody UserInfoVo userInfoVo){
        String info = userInfoVo.getInfo();
        info="%"+info+"%";
        userInfoVo.setInfo(info);
        List<UserInfo> userInfoList = userInfoService.mhselect(userInfoVo);
        return  userInfoList;
    }

    /**
     * 查询所有用户
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAllUserinfoCon")
    public Object selectAllUserinfo(){

        List<UserInfo> userInfoList = userInfoService.selectAllUserinfo();

        return userInfoList;

    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectUserByIDCon")
    public Object selectUserByID(@RequestParam int id){
        UserInfo userInfo = userInfoService.selectUserByID(id);
        return userInfo;
    }

    /**
     * 修改用户的信息
     * @param userInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("updateUserByID")
    public Object updateUserByID(@RequestBody UserInfo userInfo){
        int i = userInfoService.updateUserByID(userInfo);
        if (i!=1){
            return false;
        }
        return true;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUserByID")
    public Object deleteUserByID(@RequestParam int id){
        int i = userInfoService.deleteUserByID(id);
        if (i!=1){
            return false;
        }
        return true;
    }

    /**
     * 增加用户
     * @param userInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("addUserinfo")
    public Object addUserinfo(@RequestBody UserInfo userInfo){
        int i = userInfoService.insertUserinfo(userInfo);
        if (i!=1){
            return false;
        }
        return true;
    }

    /**
     * 根据id查询角色分配情况
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectRoleCon")
    public Object selectRoleCon(@RequestParam int id){
        List<RoleDto> roleDTOList = userInfoService.selectRoleCon(id);
        System.out.println(id);
        return roleDTOList;
    }

    /**
     * 增加用户和角色关系
     * @param userInfoVo
     * @return
     */
    @ResponseBody
    @RequestMapping("insertUserandRole")
    public Object insertUserandRole(@RequestBody UserInfoVo userInfoVo){
        int i = userInfoService.insertUserandRole(userInfoVo);
        if (i!=1){
            return false;
        }
        return true;
    }

    /**
     * 删除用户和角色关系
     * @param userInfoVo
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUserandRole")
    public Object deleteUserandRole(@RequestBody UserInfoVo userInfoVo){
        int i = userInfoService.deleteUserandRole(userInfoVo);
        if (i!=1){
            return false;
        }
        return true;
    }

    /**
     * 根据用户ID查该用户的所有权限菜单
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAllMenuByUserID")
    public Object selectAllMenuByUserID(HttpSession session){
        //获取请求用户的ID
        UserInfo userinfo =(UserInfo)session.getAttribute("userinfo");
        int userid = userinfo.getUSERID();
        List<JDTDto> jdtDtoList = userInfoService.selectAllMenuByUserID(userid);
        return jdtDtoList;
    }

    /**
     * 用户名查重
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("checkName")
    public Object checkName(@RequestParam String username){
        List<UserInfo> userInfoList = userInfoService.checkName(username);
        if (userInfoList.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
