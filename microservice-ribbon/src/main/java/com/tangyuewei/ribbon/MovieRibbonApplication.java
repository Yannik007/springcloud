package com.tangyuewei.ribbon;
/*
* @Description :
* @Date : 2018/6/26  10:46  
* */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication {
    /**
     * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
     * Ribbon工作时分为两步：第一步先选择 Eureka Server, 它优先选择在同一个Zone且负载较少的Server；
     * 第二步再根据用户指定的策略，在从Server取到的服务注册列表中选择一个地址。
     * 其中Ribbon提供了多种策略，例如轮询、随机、根据响应时间加权等。
     * 启动后，访问多次http://localhost:8010/ribbon/1，然后打开两个microservice-provider-user实例的控制台，
     * 查看两个实例输出的日志内容
     * @return restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonApplication.class, args);
    }
}
