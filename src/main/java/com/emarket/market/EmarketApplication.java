package com.emarket.market;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.emarket.market.dao")
public class EmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmarketApplication.class, args);
    }

}
