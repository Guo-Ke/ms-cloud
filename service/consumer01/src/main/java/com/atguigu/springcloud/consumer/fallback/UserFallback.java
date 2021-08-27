package com.atguigu.springcloud.consumer.fallback;

import com.atguigu.springcloud.consumer.sao.UserSao;
import org.springframework.stereotype.Component;

/**
 * @author 郑启
 * @date 2021/05/18 15:44
 */
@Component
public class UserFallback implements UserSao {
	@Override
	public String getName(String consumerName) {
		return "user.getName 服务繁忙，请稍后再试";
	}

	@Override
	public String getTimeout() {
		return "user.getTimeout 服务繁忙，请稍后再试";
	}

	@Override
	public String getDivide(int divisor) {
		return "user.getDivide 服务繁忙，请稍后再试";
	}

	@Override
	public String getConfigInfo() {
		return "user.getConfigInfo 服务繁忙，请稍后再试";
	}
}
