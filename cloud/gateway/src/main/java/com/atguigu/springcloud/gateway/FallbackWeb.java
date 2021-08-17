package com.atguigu.springcloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Objects;

/**
 * @author 郑启
 * @date 2021/05/26 09:31
 */
@RestController
@Slf4j
public class FallbackWeb {
	@RequestMapping("/consumerFallback")
	public String consumerFallback(ServerWebExchange exchange){
		ServerHttpResponse response = exchange.getResponse();
		log.info(Objects.requireNonNull(response.getStatusCode()).getReasonPhrase());
		return "consumer请求超时";
	}
}
