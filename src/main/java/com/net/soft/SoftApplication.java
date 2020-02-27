package com.net.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.net.soft.mapper")
public class SoftApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoftApplication.class, args);
    }
}
