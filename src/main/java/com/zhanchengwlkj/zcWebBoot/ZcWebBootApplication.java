package com.zhanchengwlkj.zcWebBoot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zhanchengwlkj.zcWebBoot.dao")
public class ZcWebBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcWebBootApplication.class, args);
    }

}

