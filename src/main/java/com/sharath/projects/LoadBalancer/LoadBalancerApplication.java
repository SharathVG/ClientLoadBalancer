package com.sharath.projects.LoadBalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class LoadBalancerApplication {

	@Autowired
	private RestTemplate RestTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}

	@RequestMapping("/")
	public String myMethod() {
		return RestTemplate.getForEntity("http://GatewayService/locationservice", String.class).getBody();
	}
	
}
