package com.lx.leeblog.pojo;

public class UserRole {
    private Integer id;

    private Long uid;

    private Long rid;

    public UserRole(Integer id, Long uid, Long rid) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
    }

    public UserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}