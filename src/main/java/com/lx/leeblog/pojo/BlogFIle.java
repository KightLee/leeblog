package com.lx.leeblog.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
public class BlogFIle {
    private Long id;

    private MultipartFile appreciation;

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

}
