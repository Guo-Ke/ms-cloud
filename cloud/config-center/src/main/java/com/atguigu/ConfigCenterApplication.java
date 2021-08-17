package com.atguigu;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 郑启
 * @date 2021/08/17 15:50
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigCenterApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
}
