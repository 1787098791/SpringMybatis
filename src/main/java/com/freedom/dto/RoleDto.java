package com.freedom.dto;

public class RoleDto {
    private String flag;
    private String roleid;
    private String rolename;
    private String shortname;

    public RoleDto() {
    }

    public RoleDto(String flag, String roleid, String rolename, String shortname) {
        this.flag = flag;
        this.roleid = roleid;
        this.rolename = rolename;
        this.shortname = shortname;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
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
        return "RoleDTO{" +
                "flag='" + flag + '\'' +
                ", roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", shortname='" + shortname + '\'' +
                '}';
    }
}
