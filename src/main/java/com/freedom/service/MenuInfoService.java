package com.freedom.service;

import com.freedom.Vo.MenuInfoVo;
import com.freedom.dto.JDTDto;

import java.util.List;

public interface MenuInfoService {
    /**
     * 根据roleid查询该id的权限情况
     * @param id
     * @return
     */
    List<JDTDto> selectJDTbyid(int id);

    /**
     * 查找所有父菜单的ID
     * @return
     */
    List<Integer> selectAllParentMenu();

    /**
     * 增加角色和权限菜单关系
     * @param menuInfoVo
     * @return
     */
    int insertRoleAndMenu(MenuInfoVo menuInfoVo);

    /**
     * 根据roleid删除角色和权限菜单关系
     * @param id
     * @return
     */
    int deleteRoleAndMenu(int id);
}
