package com.lx.leeblog.pojo;

public class Tag {
    private Long id;

    private String name;

    private Long tagid;

    public Tag(Long id, String name, Long tagid) {
        this.id = id;
        this.name = name;
        this.tagid = tagid;
    }

    public Tag() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }
}