package com.atguigu.springcloud.api;

import com.atguigu.springcloud.provider.MessageProvider;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 郑启
 * @date 2021/08/27 15:21
 */
@RestController
@RequestMapping("/messageProvider")
public class MessageProviderApi {
	@Resource
	private MessageProvider messageProvider;

	@GetMapping(value = "/send", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String send(){
		return messageProvider.send();
	}

}
