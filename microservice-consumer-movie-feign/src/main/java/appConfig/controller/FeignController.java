package appConfig.controller;/*
* @Description :
* @Date : 2018/6/26  11:00  
* */

import appConfig.client.UserFeignClient;
import appConfig.client.UserFeignHystrixClient;
import appConfig.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignClient.findByIdFeign(id);
        return user;
    }
    @GetMapping("feignWithHystrix/{id}")
    public User findByIdFeignWithHystrix(@PathVariable Long id) {
        User user = this.userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}