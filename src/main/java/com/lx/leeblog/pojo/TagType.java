package com.lx.leeblog.pojo;

import java.util.List;

public class TagType {
    private Long id;

    private String tagtypedesc;

    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public TagType(Long id, String tagtypedesc) {
        this.id = id;
        this.tagtypedesc = tagtypedesc;
    }

    public TagType() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagtypedesc() {
        return tagtypedesc;
    }

    public void setTagtypedesc(String tagtypedesc) {
        this.tagtypedesc = tagtypedesc == null ? null : tagtypedesc.trim();
    }
}
