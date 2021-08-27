package atguigu.provider.api;


import atguigu.provider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑启
 * @date 2021/05/13 14:32
 */
@RestController
@RequestMapping("/user")
public class UserApi {
	@Autowired
	private UserService userService;

	@HystrixCommand(commandKey = "UserApi#getName")
	@GetMapping(value = "/getName", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String getName(@RequestParam String consumerName) {
		return userService.getName(consumerName);
	}

	@GetMapping(value = "/getTimeout", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String getTimeout() {
		return userService.getTimeout();
	}

	@GetMapping(value = "/getDivide", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String getDivide(@RequestParam int divisor) {
		return userService.getDivide(divisor);
	}

	@GetMapping(value = "/getConfigInfo", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String getConfigInfo() {
		return userService.getConfigInfo();
	}
}
