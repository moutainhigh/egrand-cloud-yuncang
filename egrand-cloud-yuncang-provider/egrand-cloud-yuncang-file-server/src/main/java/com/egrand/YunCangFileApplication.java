package com.egrand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "com.egrand.cloud.yuncang.file.server.mapper")
public class YunCangFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(YunCangFileApplication.class, args);
    }
}