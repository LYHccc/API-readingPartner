package com.example.readingpartner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.readingpartner.mapper")
public class ReadingpartnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingpartnerApplication.class, args);
    }

}
