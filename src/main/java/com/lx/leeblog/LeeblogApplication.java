package com.lx.leeblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lx.leeblog.dao")
public class LeeblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeeblogApplication.class, args);
    }

}
