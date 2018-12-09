package cn.tedu.provider.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.tedu.provider.domain.Dept;
import cn.tedu.provider.feign.DeptFeign;



@RestController
public class DeptController {
	@Resource
	private DeptFeign deptFeign;  //直接注入Feign接口，不过需要在主启动类上扫描该类所在的包或者父包
	
	/**
	 * 根据部门Id获取部门
	 * @param id
	 * @return
	 */
	@GetMapping("/dept/{id}")
	public Dept getDept(@PathVariable("id") Integer id) {
		return deptFeign.get(id);
	}
	
	/**
	 * 添加部门，json方式提交
	 * @param dept
	 * @return
	 */
	@PostMapping("/dept")
	public Dept addDept(@RequestBody Dept dept) {
		return deptFeign.addDept(dept);
	}
}
