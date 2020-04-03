package com.tangyuewei.feign.controller;/*
* @Description :
* @Date : 2018/6/26  11:00  
* */

import com.tangyuewei.feign.client.UserFeignClient;
import com.tangyuewei.feign.client.UserFeignHystrixClient;
import com.tangyuewei.feign.entity.User;
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
        User user = userFeignClient.findByIdFeign(id);
        return user;
    }
    @GetMapping("feignWithHystrix/{id}")
    public User findByIdFeignWithHystrix(@PathVariable Long id) {
        User user = this.userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}
