package com.atguigu.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 郑启
 * @date 2021/05/17 11:56
 */
@Slf4j
public class MyRoundRobinRule extends AbstractLoadBalancerRule {
	private AtomicInteger atomicInteger;
	private final int RETRY_COUNT = 10;

	public MyRoundRobinRule() {
		atomicInteger = new AtomicInteger(0);
	}

	public MyRoundRobinRule(ILoadBalancer lb) {
		this();
		setLoadBalancer(lb);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}

	@Override
	public Server choose(Object key) {
		ILoadBalancer loadBalancer = getLoadBalancer();
		int count = 0;
		while (count++ < RETRY_COUNT) {
			//所有实例
//			List<Server> allServers = loadBalancer.getAllServers();
			//可达实例
			List<Server> reachableServers = loadBalancer.getReachableServers();
			if (CollectionUtils.isEmpty(reachableServers)) {
				log.warn("该ribbon[{}]中无有效服务", loadBalancer);
				return null;
			}
			int upSize = reachableServers.size();
			int index = atomicInteger.getAndIncrement() % upSize;
			Server server = reachableServers.get(index);
			log.info("服务index：" + index);
			log.info("服务HostPort：" + server.getHostPort());
			//该服务实例是否有效（存活并注册）
			if (server.isAlive() || server.isReadyToServe()) {
				return server;
			}
		}
		if (count > RETRY_COUNT) {
			log.warn("经[{}]次轮询后该ribbon[{}]中仍无有效服务", RETRY_COUNT, loadBalancer);
		}
		return null;
	}

	/**
	 * CAS 加自旋锁获取自增1。该方法在AtomicInteger中自带，无需自己实现
	 *
	 * @return int
	 * @author 郑启
	 * @date 2021/05/17 16:25
	 */
	@Deprecated
	private int getAndIncrement() {
		int current;
		int next;
		do {
			current = atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current + 1;
		} while (!this.atomicInteger.compareAndSet(current, next));
		return next;
	}
}
