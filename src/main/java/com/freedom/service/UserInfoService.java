package com.freedom.service;

import com.freedom.Vo.UserInfoVo;

import com.freedom.dto.JDTDto;
import com.freedom.dto.RoleDto;
import com.freedom.pojo.UserInfo;

import java.util.List;


public interface UserInfoService {
    /**
     * 登录判断
     * @param userInfoVo
     * @return
     */
    UserInfo login(UserInfoVo userInfoVo);

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    int insertregist(UserInfo userInfo);
    /**
     * 条件查询相当于模糊查询全部
     * @param userInfoVo
     * @return
     */
    List<UserInfo> mhselect(UserInfoVo userInfoVo);

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> selectAllUserinfo();

    /**
     * 根据id查用户
     * @param id
     * @return
     */
    UserInfo selectUserByID(int id);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updateUserByID(UserInfo userInfo);

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteUserByID(int id);

    /**
     * 增加用户
     * @return
     */
    int insertUserinfo(UserInfo userInfo);

    /**
     * 根据id查询角色分配情况
     * @param id
     * @return
     */
    List<RoleDto> selectRoleCon(int id);

    /**
     * 增加用户和角色关系
     * @param userInfoVo
     * @return
     */
    int insertUserandRole(UserInfoVo userInfoVo);

    /**
     * 删除用户和角色关系
     * @param userInfoVo
     * @return
     */
    int deleteUserandRole(UserInfoVo userInfoVo);
    /**
     * 根据用户id查询该用户的所有权限菜单
     * @param userid
     * @return
     */
    List<JDTDto> selectAllMenuByUserID(int userid);

    /**
     * 用户名查重
     * @param username
     * @return
     */
    List<UserInfo> checkName(String username);

     void test() throws MyException;
}
