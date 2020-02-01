package com.lx.leeblog.pojo;

public class Role {
    private Long id;

    private String rolename;

    private String roledesc;

    public Role(Long id, String rolename, String roledesc) {
        this.id = id;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }
}