package com.hopu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hopu.mapper")
public class SpringbootShixun01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootShixun01Application.class, args);
    }

}
