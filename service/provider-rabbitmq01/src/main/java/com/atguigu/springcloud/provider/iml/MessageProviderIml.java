package com.atguigu.springcloud.provider.iml;

import com.atguigu.springcloud.provider.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author 郑启
 * @date 2021/08/27 14:42
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderIml implements MessageProvider {
	// beanName 必须为配置文件中 bindings 下的 channel 名称
	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		output.send(MessageBuilder.withPayload("hello").build());
		log.info("say hello");
		return null;
	}
}
