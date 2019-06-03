package com.freedom.controller;

import com.freedom.Vo.MenuInfoVo;
import com.freedom.dto.JDTDto;
import com.freedom.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuInfoController {
    @Autowired
    MenuInfoService menuInfoService;

    /**
     * 根据ID查找角色的权限信息
     * @param id
     * @return
     */
    @RequestMapping("selectJDTbyid")
    public Object selectJDTbyid(@RequestParam int id){
        List<JDTDto> jdtDtoList = menuInfoService.selectJDTbyid(id);
        return jdtDtoList;
    }

    /**
     * 增加角色和权限菜单关系
     * @param menuInfoVo
     * @return
     */
    @RequestMapping("insertRoleAndMenu")
    public Object insertRoleAndMenu(@RequestBody MenuInfoVo menuInfoVo){
        int i = menuInfoService.insertRoleAndMenu(menuInfoVo);
        if (i>0){
            return true;
        }
        return false;
    }
}
