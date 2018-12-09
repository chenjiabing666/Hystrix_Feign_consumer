package cn.tedu.provider.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Feign的负载均衡算法的配置类，和Ribbon一样
 */
@Configuration
public class FeignRule {
	
	/**
	 * 注入随机算法
	 * @return
	 */
//	@Bean
//	public IRule myRule() {
//		return new RandomRule();   //直接创建一个随机算法返回即可
//	}
}
