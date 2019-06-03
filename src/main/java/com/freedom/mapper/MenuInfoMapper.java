package com.freedom.mapper;

import com.freedom.Vo.MenuInfoVo;
import com.freedom.dto.JDTDto;

import java.util.List;

public interface MenuInfoMapper {
    /**
     * 根据roleid查询该id的权限情况
     * @param id
     * @return
     */
    List<JDTDto> selectJDTbyid(int id);

    /**
     * 查询所有父菜单的ID
     * @return
     */
    List<Integer> selectAllParentMenu();

    /**
     * 根据roleid删除角色和权限菜单关系
     * @param id
     * @return
     */
    int deleteRoleAndMenu(int id);
    /**
     * 增加角色和权限菜单关系
     * @param menuInfoVo
     * @return
     */
    int insertRoleAndMenu(MenuInfoVo menuInfoVo);
}
