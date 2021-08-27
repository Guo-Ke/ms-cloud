package atguigu.provider.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 郑启
 * @date 2021/05/13 17:01
 */
@RefreshScope
@Service
public class UserService {
	@Value("${eureka.instance.instance-id}")
	private String providerName;

	@Value("${config.info}")
	private String configInfo;

	public String getName(String consumerName) {
		return consumerName + "--->" + providerName;
	}

	public String getTimeout() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return providerName + "----timeout";
	}

	public String getDivide(int divisor) {
		return "错误" + 5/divisor;
	}

	public String getConfigInfo(){
		return configInfo;
	}
}
