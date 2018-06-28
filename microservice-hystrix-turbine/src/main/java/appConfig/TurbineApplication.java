package appConfig;
/*
* @Description :
* @Date : 2018/6/26  14:11  
* */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 通过@EnableTurbine接口，激活对Turbine的支持。
 * 在复杂的分布式系统中，相同服务的节点经常需要部署上百甚至上千个，
 * 很多时候，运维人员希望能够把相同服务的节点状态以一个整体集群的形式展现出来，
 * 这样可以更好的把握整个系统的状态。
 * 为此，Netflix提供了一个开源项目（Turbine）来提供把多个hystrix.stream的内容聚合为一个数据源供Dashboard展示。
 * 启动项目：microservice-discovery-eureka
 *启动项目：microservice-provider-user
 *启动项目：microservice-consumer-movie-ribbon-with-hystrix
 *启动项目：microservice-consumer-movie-feign-with-hystrix-stream
 *启动项目：microservice-hystrix-dashboard
 *启动项目：microservice-hystrix-turbine（即本例）
 *访问：http://localhost:8011/ribbon/1，调用ribbon接口
 *访问：http://localhost:8022/feign/1，调用feign接口
 *访问：http://localhost:8031/turbine.stream，可查看到和Hystrix监控类似的内容：
 * @author tyw
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApplication.class).web(true).run(args);
    }
}