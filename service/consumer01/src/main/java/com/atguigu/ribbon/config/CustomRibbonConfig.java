package com.atguigu.ribbon.config;

import com.atguigu.ribbon.rule.MyRoundRobinRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 负载均衡配置类。若只需对部分服务采用该策略，则应在ComponentScan之外配置
 * @author 郑启
 * @date 2021/05/17 10:29
 */
//@Configuration
public class CustomRibbonConfig {
	//替换默认的规则 RoundRobinRule 为 RandomRule
	@Bean
	public IRule randomRule() {
	    return new RandomRule();
	}
	//替换默认的规则为自定义规则
//	@Bean
	public IRule myRule() {
	    return new MyRoundRobinRule();
	}
}
