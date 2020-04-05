package com.tangyuewei.feign.client.fallback;

import com.tangyuewei.feign.client.UserFeignHystrixClient;
import com.tangyuewei.feign.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
 * @author tyw
 */
@Component
public class HystrixClientFallback implements UserFeignHystrixClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	/**
	 * hystrix fallback方法
	 * @param id id
	 * @return 默认的用户
	 */
	@Override
	public User findByIdFeign(Integer id) {
		LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
		User user = new User();
		user.setId(0);
		user.setName("default username");
		user.setAge(0);
		return user;
	}
}
