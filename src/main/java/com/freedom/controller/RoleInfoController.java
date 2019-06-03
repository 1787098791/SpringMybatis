package com.freedom.controller;

import com.freedom.Vo.RoleInfoVo;
import com.freedom.pojo.RoleInfo;
import com.freedom.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleInfoController {
    @Autowired
    RoleInfoService roleInfoService;

    /**
     * 查询所有角色信息
     * @return
     */
    @RequestMapping("selectAllRole")
    public Object selectAllRole(){
        List<RoleInfo> roleInfoList = roleInfoService.selectAllRole();
        return roleInfoList;
    }

    /**
     * 模糊查询角色
     * @param roleInfoVo
     * @return
     */
    @RequestMapping("mhselectrole")
    public Object mhselect(@RequestBody RoleInfoVo roleInfoVo){
        List<RoleInfo> roleInfoList = roleInfoService.mhselect(roleInfoVo);
        return roleInfoList;
    }
}
