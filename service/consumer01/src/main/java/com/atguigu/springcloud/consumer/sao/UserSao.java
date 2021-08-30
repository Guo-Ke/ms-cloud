package com.atguigu.springcloud.consumer.sao;

import com.atguigu.springcloud.consumer.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 郑启
 * @date 2021/05/13 16:52
 */
@FeignClient(name = "provider", path = "/provider/user", fallback = UserFallback.class)
public interface UserSao {
//	@HystrixCommand(commandKey = "UserSao#getName")
	@GetMapping(value = "/getName", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	String getName(@RequestParam String consumerName);

	@GetMapping(value = "/getTimeout", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	String getTimeout();

	@GetMapping(value = "/getDivide", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	String getDivide(@RequestParam int divisor);

	@GetMapping(value = "/getConfigInfo", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	String getConfigInfo();
}
