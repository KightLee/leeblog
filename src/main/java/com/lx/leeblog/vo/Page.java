package com.lx.leeblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * create by @author lixing on 2020/1/20 11:45
 * 接受的参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Page implements Serializable {
    private Integer page = 1;
    private Integer rows = 5;
    private Integer totalRecord;
    private Integer totalPage;
    private String keyWord;
    private Integer start;
    private String userid;
    private String otherid;
}
