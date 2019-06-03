package com.freedom.service.imp;

import com.freedom.Vo.RoleInfoVo;
import com.freedom.mapper.RoleInfoMapper;
import com.freedom.pojo.RoleInfo;
import com.freedom.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleInfoServiceImp implements RoleInfoService {
    @Autowired
    RoleInfoMapper roleInfoMapper;

    /**
     * 查询所有角色信息
     * @return
     */
    public List<RoleInfo> selectAllRole() {
        List<RoleInfo> roleInfoList = roleInfoMapper.selectAllRole();
        return roleInfoList;
    }

    /**
     * 模糊查询角色信息
     * @param roleInfoVo
     * @return
     */
    public List<RoleInfo> mhselect(RoleInfoVo roleInfoVo) {
        List<RoleInfo> roleInfoList = roleInfoMapper.mhselect(roleInfoVo);
        return roleInfoList;
    }
}
