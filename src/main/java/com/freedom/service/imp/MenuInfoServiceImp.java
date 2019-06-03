package com.freedom.service.imp;

import com.freedom.Vo.MenuInfoVo;
import com.freedom.dto.JDTDto;
import com.freedom.mapper.MenuInfoMapper;
import com.freedom.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class MenuInfoServiceImp implements MenuInfoService {
    @Autowired
    MenuInfoMapper menuInfoMapper;

    List<Integer> idlist;
    /**
     * 根据roleid查询该id的权限情况
     * @param id
     * @return
     */
    public List<JDTDto> selectJDTbyid(int id) {
        List<JDTDto> jdtDtoList = menuInfoMapper.selectJDTbyid(id);
        return jdtDtoList;
    }

    /**
     * 查找所有父菜单的ID
     * @return
     */
    public List<Integer> selectAllParentMenu() {
        idlist = menuInfoMapper.selectAllParentMenu();
        return idlist;
    }

    /**
     * 根据roleid删除角色和权限菜单关系
     * @param id
     * @return
     */
    public int deleteRoleAndMenu(int id) {
        int i = menuInfoMapper.deleteRoleAndMenu(id);
        return i;
    }
    /**
     * 增加角色和权限菜单关系
     * @param menuInfoVo
     * @return
     */
    public int insertRoleAndMenu(MenuInfoVo menuInfoVo) {
        //调用查找所有父菜单的ID的方法，返回父菜单的集合
        selectAllParentMenu();
        //调用根据roleid删除角色和权限菜单关系的方法
        deleteRoleAndMenu(menuInfoVo.getRoleid());

        int[] menuids = menuInfoVo.getMenuids();
        //menuids数组转集合
        ArrayList<Integer> list = new ArrayList();
        for (int j =0;j<menuids.length;j++){
            list.add(menuids[j]);
        }
        //去除list中的父ID
        for (Integer fatherid:idlist){
            if (list.contains(fatherid)){
                list.remove(fatherid);
            }
        }
        //list集合转数组
        int[] childids = new int[list.size()];
        for (int k=0;k<list.size();k++){
            childids[k]=list.get(k);
        }
        menuInfoVo.setMenuids(childids);
        int i = menuInfoMapper.insertRoleAndMenu(menuInfoVo);
        return i;
    }


}
