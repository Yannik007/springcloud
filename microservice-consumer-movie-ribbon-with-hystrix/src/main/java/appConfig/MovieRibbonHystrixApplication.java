package appConfig;/*
* @Description :
* @Date : 2018/6/26  11:06  
* */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 * @author eacdy
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MovieRibbonHystrixApplication {
    /**
     * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.实现熔断器
     * 验证：1.启动注册中心：microservice-discovery-eureka2.启动服务提供方：microservice-provider-user3.启动服务消费方：microservice-consumer-movie-ribbon-with-hystrix
     * 4.访问：http://localhost:8011/ribbon/1，获得结果：{"id":1,"username":"Tom","age":12}
     * 5.关闭服务提供方,访问：http://localhost:8011/ribbon/1，获得结果：{"id":-1,"username":"default username","age":0}
     * 另外日志打印：c.i.c.s.u.service.RibbonHystrixService : 异常发生，进入fallback方法，接收的参数：id = 1 。
     * @return restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonHystrixApplication.class, args);
    }
}
