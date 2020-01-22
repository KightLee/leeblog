package com.lx.leeblog.vo;

import lombok.Data;

import java.util.List;

/**
 * create by @author lixing on 2020/1/20 12:30
 * 封装返回的数据，用泛型区分不同的pojo
 */
@Data
public class ResultVo<T> {
    Integer code;
    String msg;
    Integer count;
    List<T> data;
}
