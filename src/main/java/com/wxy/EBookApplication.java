package com.wxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wxy.*.mapper")
public class EBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(EBookApplication.class, args);
    }
}
