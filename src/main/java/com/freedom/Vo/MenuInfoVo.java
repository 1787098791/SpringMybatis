package com.freedom.Vo;

public class MenuInfoVo {
    private int roleid;
    private int[] menuids;

    public MenuInfoVo() {
    }

    public MenuInfoVo(int roleid, int[] menuids) {
        this.roleid = roleid;
        this.menuids = menuids;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int[] getMenuids() {
        return menuids;
    }

    public void setMenuids(int[] menuids) {
        this.menuids = menuids;
    }

}
