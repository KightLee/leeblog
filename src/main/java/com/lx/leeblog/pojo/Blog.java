package com.lx.leeblog.pojo;

import java.util.Date;

public class Blog {
    private Long id;

    private String appreciation;

    private Boolean commentabled;

    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published;

    private Long recommend;

    private Long shareStatement;

    private String title;

    private Date updateTime;

    private Long views;

    private Long typeId;

    private Long userId;

    private String content;

    public Blog(Long id, String appreciation, Boolean commentabled, Date createTime, String description, String firstPicture, String flag, Boolean published, Long recommend, Long shareStatement, String title, Date updateTime, Long views, Long typeId, Long userId, String content) {
        this.id = id;
        this.appreciation = appreciation;
        this.commentabled = commentabled;
        this.createTime = createTime;
        this.description = description;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.published = published;
        this.recommend = recommend;
        this.shareStatement = shareStatement;
        this.title = title;
        this.updateTime = updateTime;
        this.views = views;
        this.typeId = typeId;
        this.userId = userId;
        this.content = content;
    }

    public Blog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation == null ? null : appreciation.trim();
    }

    public Boolean getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture == null ? null : firstPicture.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Long getRecommend() {
        return recommend;
    }

    public void setRecommend(Long recommend) {
        this.recommend = recommend;
    }

    public Long getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Long shareStatement) {
        this.shareStatement = shareStatement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}