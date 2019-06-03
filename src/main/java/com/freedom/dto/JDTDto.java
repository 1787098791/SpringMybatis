package com.freedom.dto;

import java.util.List;

public class JDTDto {
    	/*      "id": 1,
                "pid": 0,
                "seqno": 0,
                "name": "系统权限菜单",
                "url": null,
                "icon": "fa fa-sitemap",
                "open": true,
                "checked": false,
                "children": */
    	//权限表自连接父菜单-子菜单   一对多
    	private int id;
    	private int pid;
    	private int seqno;
    	private String name;
    	private String icon;
    	private boolean open=true;
    	private boolean checked;//若数据库返回1则为true,0为false,表示这个权限该角色有没有
    	private List<JDTDto> children;

    public JDTDto() {
    }

    public JDTDto(int id, int pid, int seqno, String name, String icon, boolean open, boolean checked, List<JDTDto> children) {
        this.id = id;
        this.pid = pid;
        this.seqno = seqno;
        this.name = name;
        this.icon = icon;
        this.open = open;
        this.checked = checked;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return !checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<JDTDto> getChildren() {
        return children;
    }

    public void setChildren(List<JDTDto> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "JDTDto{" +
                "id=" + id +
                ", pid=" + pid +
                ", seqno=" + seqno +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
