package com.freedom.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class UserInfoVo implements Serializable  {

    @JsonProperty("USERNAME")//处理json的key大写实体类接收不到数据的问题
    @NotBlank(message = "请输入正确用户名!")
    @Length(min = 2,max = 20,message = "请输入正确用户名!")
    private String USERNAME;
    @JsonProperty("PASSWORD")
    @NotBlank(message = "密码格式不正确!")
    @Length(min = 6,max = 11,message = "密码格式不正确!")
    private String PASSWORD;
    //模糊查询条件信息
    private String info;

    //用户id
    private int id;
    //角色id
    private int roleid;

    public UserInfoVo() {
    }

    public UserInfoVo(String USERNAME, String PASSWORD, String info, int id, int roleid) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.info = info;
        this.id = id;
        this.roleid = roleid;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", info='" + info + '\'' +
                ", id=" + id +
                ", roleid=" + roleid +
                '}';
    }
}
