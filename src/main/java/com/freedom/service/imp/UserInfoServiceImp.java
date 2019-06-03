package com.freedom.service.imp;

import com.freedom.Vo.UserInfoVo;
import com.freedom.dto.JDTDto;
import com.freedom.dto.RoleDto;
import com.freedom.mapper.UserInfoMapper;
import com.freedom.pojo.UserInfo;
import com.freedom.service.UserInfoService;
import com.freedom.utils.FinalMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 登录判断
     * @param userInfoVo
     * @return
     */
    public UserInfo login(UserInfoVo userInfoVo) {
        //登录时对传进来的密码也要加密
        userInfoVo.setPASSWORD(FinalMD5.getFinalMD5(userInfoVo.getPASSWORD()));
        UserInfo userInfo = userInfoMapper.login(userInfoVo);
        return userInfo;
    }

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    public int insertregist(UserInfo userInfo) {
       //注册时必须对密码加密
        userInfo.setPASSWORD(FinalMD5.getFinalMD5(userInfo.getPASSWORD()));
        int i = userInfoMapper.regist(userInfo);
        return i;
    }

    /**
     * 模糊查询
     * @param userInfoVo
     * @return
     */
    public List<UserInfo> mhselect(UserInfoVo userInfoVo) {
        List<UserInfo> userInfoList = userInfoMapper.mhselect(userInfoVo);
        return userInfoList;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<UserInfo> selectAllUserinfo() {
        List<UserInfo> userInfoList = userInfoMapper.selectAllUserinfo();
        return userInfoList;
    }

    /**
     * 根据id查用户
     * @param id
     * @return
     */
    public UserInfo selectUserByID(int id) {
        UserInfo userInfo = userInfoMapper.selectUserByID(id);
        return userInfo;
    }

    /**
     * 更新用户
     * @param userInfo
     * @return
     */
    public int updateUserByID(UserInfo userInfo) {
        int i = userInfoMapper.updateUserByID(userInfo);
        return i;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUserByID(int id) {
        int i = userInfoMapper.deleteUserByID(id);
        return i;
    }

    /**
     * 增加用户
     * @param userInfo
     * @return
     */
    public int insertUserinfo(UserInfo userInfo) {
        //对密码加密
        userInfo.setPASSWORD(FinalMD5.getFinalMD5(userInfo.getPASSWORD()));
        int i = userInfoMapper.insertUserinfo(userInfo);
        return i;
    }

    /**
     * 根据id查询角色分配
     * @param id
     * @return
     */
    public List<RoleDto> selectRoleCon(int id) {
        List<RoleDto> roleDTOList = userInfoMapper.selectRoleCon(id);
        return roleDTOList;
    }

    /**
     * 增加用户和角色关系
     * @param userInfoVo
     * @return
     */
    public int insertUserandRole(UserInfoVo userInfoVo) {
        int i = userInfoMapper.insertUserandRole(userInfoVo);
        return i;
    }

    /**
     * 删除用户和角色关系
     * @param userInfoVo
     * @return
     */
    public int deleteUserandRole(UserInfoVo userInfoVo) {
        int i = userInfoMapper.deleteUserandRole(userInfoVo);
        return i;
    }

    /**
     * 根据用户id查询该用户的所有权限菜单
     * @param userid
     * @return
     */
    public List<JDTDto> selectAllMenuByUserID(int userid) {
        List<JDTDto> jdtDtoList = userInfoMapper.selectAllMenuByUserID(userid);

        return jdtDtoList;
    }

    /**
     * 用户名查重
     * @param username
     * @return
     */
    public List<UserInfo> checkName(String username) {
        List<UserInfo> userInfoList = userInfoMapper.checkName(username);
        return userInfoList;
    }
}
