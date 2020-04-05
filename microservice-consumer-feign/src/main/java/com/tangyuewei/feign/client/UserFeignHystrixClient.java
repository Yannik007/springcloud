package com.tangyuewei.feign.client;

import com.tangyuewei.feign.client.fallback.HystrixClientFallback;
import com.tangyuewei.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * 在Feign中使用Hystrix
 * @author tyw
 */
@FeignClient(name = "microservice-provider-user", path = "user", fallback = HystrixClientFallback.class)
public interface UserFeignHystrixClient {
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    User findByIdFeign(@PathVariable Integer id);

}
