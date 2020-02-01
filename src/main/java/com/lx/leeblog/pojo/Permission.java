package com.lx.leeblog.pojo;

public class Permission {
    private Long id;

    private String menuname;

    public Permission(Long id, String menuname) {
        this.id = id;
        this.menuname = menuname;
    }

    public Permission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }
}