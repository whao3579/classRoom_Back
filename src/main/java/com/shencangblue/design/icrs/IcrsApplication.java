package com.shencangblue.design.icrs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shencangblue.design.icrs.mapper")
public class IcrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcrsApplication.class, args);
    }

}
