package cn.tedu.provider.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.tedu.provider.domain.Dept;
/**
 * Hystrix和Feign结合实现服务的降级
 * @FeignClient 标注这个接口使用Feign实现负载均衡
 * 	1、name指定了微服务提供者的实例名称
 * 	2、fallbackFactory指定了熔断的接口，一旦出现异常就会调用这个接口的方法返回指定的熔断信息
 */
@FeignClient(name="DEPT-PROVIDER",fallbackFactory=DeptFallBack.class)
public interface DeptFeign {
	
	/**
	 * 获取部门，使用Get方式请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dept/{id}",method=RequestMethod.GET)
	Dept get(@PathVariable("id")Integer id);
	
	/**
	 * 添加部门，使用POST请求的方式
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="/dept",method=RequestMethod.POST)
	Dept addDept(Dept dept);
}
