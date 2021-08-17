package com.atguigu.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 郑启
 * @date 2021/05/12 10:05
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//修改特定服务的负载均衡策略。若集成了feign，则不用编写配置类和只用该注解
//@RibbonClient(name = "provider", configuration = CustomRibbonConfig.class)
public class Consumer01Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Consumer01Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}
