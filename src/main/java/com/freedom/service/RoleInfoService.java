package com.freedom.service;

import com.freedom.Vo.RoleInfoVo;
import com.freedom.pojo.RoleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleInfoService {
    /**
     * 查询所有角色信息
     * @return
     */
    List<RoleInfo> selectAllRole();
    /**
     * 模糊查询角色
     * @param roleInfoVo
     * @return
     */
    List<RoleInfo> mhselect(RoleInfoVo roleInfoVo);
}
