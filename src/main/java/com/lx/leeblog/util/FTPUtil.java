package com.lx.leeblog.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * create by @author lixing on 2020/2/7 15:16
 * ftp 工具类
 */
@Slf4j
@Component
@Data
public class FTPUtil {
    @Value(value = "${ftp.host}")
    private String ftpHost;

    @Value(value = "${ftp.user}")
    private String ftpUser;

    @Value(value = "${ftp.password}")
    private String ftpPass;

    @Value(value = "${ftp.port}")
    private int ftpPort;


    FTPClient ftpClient;
    public boolean uploadFile(File file) throws IOException {
        log.info("开始连接ftp服务器");
        boolean result = uploadFile("img",file);
        log.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }

    public boolean uploadFile(String remotePath, File file) throws IOException {
        boolean uploaded = true;
        FileInputStream fio = null;
        if (connectServer(ftpHost,ftpPort,ftpUser,ftpPass)) {
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                fio = new FileInputStream(file);
                ftpClient.storeFile(file.getName(), fio);
            } catch (IOException e) {
                log.error("上传文件异常", e);
                uploaded = false;
                e.printStackTrace();
            } finally {
                fio.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    private boolean connectServer(String ip,int port,String user,String pwd){
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user,pwd);
        } catch (IOException e) {
            log.error("连接FTP服务器异常",e);
        }
        return isSuccess;
    }
}


