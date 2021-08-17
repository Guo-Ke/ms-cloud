package com.atguigu.springcloud.consumer.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑启
 * @date 2021/05/14 16:35
 */
@Configuration
public class FeignConfig {
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
}