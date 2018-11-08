package appConfig.service;/*
* @Description :
* @Date : 2018/6/26  10:48  
* */

import appConfig.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://"+"MICROSERVICE-PROVIDER-USER" +"/"+ id, User.class);
    }
}
