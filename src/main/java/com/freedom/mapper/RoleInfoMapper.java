package com.freedom.mapper;

import com.freedom.Vo.RoleInfoVo;
import com.freedom.pojo.RoleInfo;

import java.util.List;

public interface RoleInfoMapper {
    /**
     * 大条件模糊查询角色
     * @param roleInfoVo
     * @return
     */
    List<RoleInfo> mhselect(RoleInfoVo roleInfoVo);

    /**
     * 查询所有角色信息
     * @return
     */
    List<RoleInfo> selectAllRole();
}
