package com.tangyuewei.provider.controller;

import com.tangyuewei.provider.domain.User;
import com.tangyuewei.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author tyw
 */
@RestController
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Resource
    private UserMapper UserMapper;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     * @param id
     * @return user信息
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        User findOne = UserMapper.selectByPrimaryKey(id);
        return findOne;
    }

}
