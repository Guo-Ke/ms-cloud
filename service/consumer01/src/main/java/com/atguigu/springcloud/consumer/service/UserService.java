package com.atguigu.springcloud.consumer.service;

import com.atguigu.springcloud.consumer.sao.UserSao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 郑启
 * @date 2021/05/13 17:01
 */
@Service
public class UserService {
	@Value("${eureka.instance.instance-id}")
	private String consumerName;

	@Qualifier("com.atguigu.springcloud.consumer.sao.UserSao")
	@Autowired
	private UserSao userSao;

	public String getName(){
		return userSao.getName(consumerName);
	}

	public String getTimeout(){
		return userSao.getTimeout();
	}

	public String getDivide(int divisor) {
		return userSao.getDivide(divisor);
	}
}
