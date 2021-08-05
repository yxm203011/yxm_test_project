package com.test.yxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.test.yxm.mapper")
@SpringBootApplication
public class YxmApplication {

    public static void main(String[] args) {
        SpringApplication.run(YxmApplication.class, args);
    }

}
