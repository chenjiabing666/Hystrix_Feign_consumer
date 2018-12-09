package cn.tedu.provider.feign;

import org.springframework.stereotype.Component;
import cn.tedu.provider.domain.Dept;
import feign.hystrix.FallbackFactory;

/**
 *  针对DeptFiegn接口的服务熔断的公共类，在其中可以对各个接口进行服务熔断响应进行定制
 *  1、这个接口必须实现`feign.hystrix.FallbackFactory`
 *  2、这个FallbackFactory中的泛型必须是`@FeignClient`标注的接口（实现负载均衡）
 */
@Component   //一定要将其注入到容器中
public class DeptFallBack implements FallbackFactory<DeptFeign> {

	/**
	 * 实现其中的方法
	 */
	@Override
	public DeptFeign create(Throwable cause) {
		//直接return这个接口的对象，并且实现其中的所有接口方法，下面的每一个接口返回的信息就将是服务熔断返回的消息
		return new DeptFeign() {
			
			@Override
			public Dept get(Integer id) {   //根据Id获取异常之后就会返回其中的信息
				Dept dept=new Dept();
				dept.setDeptId(-1);
				dept.setDeptName("服务熔断......");
				return dept;
			}

			@Override
			public Dept addDept(Dept dept) {  //添加异常返回这个信息
				dept.setDeptId(-1);
				dept.setDeptName("服务熔断......");
				return dept;
			}};
	}

}
