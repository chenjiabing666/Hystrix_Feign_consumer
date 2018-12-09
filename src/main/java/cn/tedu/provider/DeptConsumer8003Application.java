package cn.tedu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient    //eureka客户端
@EnableCircuitBreaker  //开启熔断器
@EnableFeignClients(basePackages="")   //开启Feign
public class DeptConsumer8003Application {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer8003Application.class, args);
	}
}
