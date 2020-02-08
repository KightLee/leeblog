package com.lx.leeblog.service;

import com.lx.leeblog.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * create by @author lixing on 2020/2/7 20:25
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private FTPUtil ftpUtil;

    @Value(value = "${ftp.prefix}")
    private String prefix;
    @Override
    public String upload(MultipartFile file, String path) {
        String filename = file.getOriginalFilename();
        String fileExtensionName = filename.substring(filename.lastIndexOf('.') + 1);
        String uploadFileName = UUID.randomUUID().toString()+'.'+fileExtensionName;
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            /**
             * 存进临时文件夹里, 再上传ftp服务器
             */
            file.transferTo(targetFile);
            ftpUtil.uploadFile(targetFile);
            targetFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return prefix+targetFile.getName();
    }
}
