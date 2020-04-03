package com.tangyuewei.cloud;
/*
* @Description :
* @Date : 2018/6/26  14:55  
* */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tyw
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class, args);
    }
}
