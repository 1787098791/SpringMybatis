package com.freedom.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    private static final long serialVersionUID =1L;
    @JsonProperty("USERID")
    private int USERID;
    @JsonProperty("USERNAME")
    @NotBlank(message = "用户名格式不正确!")
    @Length(min = 2,max = 20,message = "用户名格式不正确!")
    private String USERNAME;
    @JsonProperty("PASSWORD")
    @NotBlank(message = "密码格式不正确!")
    @Length(min = 6,max = 11,message = "密码格式不正确!")
    private String PASSWORD;
    @JsonProperty("REGEMAIL")
    @Pattern(regexp = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$",message = "邮箱格式不正确！")
    private String REGEMAIL;
    @JsonProperty("MOBILE")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",message = "电话号码格式不正确！")
    private String MOBILE;
    @JsonProperty("ICON")
    private String ICON;

    public UserInfo() {
    }

    public UserInfo(int USERID, String USERNAME, String PASSWORD, String REGEMAIL, String MOBILE, String ICON) {
        this.USERID = USERID;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.REGEMAIL = REGEMAIL;
        this.MOBILE = MOBILE;
        this.ICON = ICON;
    }

    public int getUSERID() {
        return USERID;
    }

    public void setUSERID(int USERID) {
        this.USERID = USERID;
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

    public String getREGEMAIL() {
        return REGEMAIL;
    }

    public void setREGEMAIL(String REGEMAIL) {
        this.REGEMAIL = REGEMAIL;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getICON() {
        return ICON;
    }

    public void setICON(String ICON) {
        this.ICON = ICON;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "USERID=" + USERID +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", REGEMAIL='" + REGEMAIL + '\'' +
                ", MOBILE='" + MOBILE + '\'' +
                ", ICON='" + ICON + '\'' +
                '}';
    }
}
