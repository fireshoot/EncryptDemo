package com.mybatis.encrypt.encryptdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mybatis.encrypt.encryptdemo.dao")
@SpringBootApplication
public class EncryptdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncryptdemoApplication.class, args);
    }

}
