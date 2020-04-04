package com.tangyuewei.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动程序，通过@EnableDiscoveryClient注解，即可将microservice-provider-user服务注册到Eureka上面去
 * 依次启动Eureka服务和microservice-provider-user服务。访问：http://localhost:8000/instance-info
 * @author tyw
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tangyuewei.provider.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
