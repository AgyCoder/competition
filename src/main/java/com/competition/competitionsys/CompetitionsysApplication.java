package com.competition.competitionsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.competition.competitionsys.dao")
public class CompetitionsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionsysApplication.class, args);
    }

}
