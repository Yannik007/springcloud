package com.tangyuewei.feign.controller;

import com.tangyuewei.feign.client.UserFeignHystrixClient;
import com.tangyuewei.feign.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("user/{id}")
    public User findByIdFeignWithHystrix(@PathVariable Integer id) {
        User user = userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}
