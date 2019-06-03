package com.freedom.pojo;

import java.io.Serializable;

public class RoleInfo implements Serializable {
    private static final long serialVersionUID =2L;
    private int roleid;
    private String rolename;
    private String shortname;

    public RoleInfo() {
    }

    public RoleInfo(int roleid, String rolename, String shortname) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.shortname = shortname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", shortname='" + shortname + '\'' +
                '}';
    }
}
