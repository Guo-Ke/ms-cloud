package com.atguigu.springcloud.listener;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author 郑启
 * @date 2021/08/27 15:54
 */
@Slf4j
@EnableBinding(Sink.class)
public class MessageListener {
	@StreamListener(Sink.INPUT)
	public void receive(@NonNull Message<String> message) {
		log.info("收到：" + message.getPayload());
	}
}
