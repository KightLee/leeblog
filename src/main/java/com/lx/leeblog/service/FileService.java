package com.lx.leeblog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * create by @author lixing on 2020/2/7 20:24
 */
public interface FileService {
    public String upload(MultipartFile file, String path);
}
