package com.wusc.consumerone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.consumerone.service.HelloService;

@RestController
@RequestMapping(value="hello",produces="application/json")
public class HelloController {
	@Autowired
	private HelloService helloService;
//	@Autowired
//	private DiscoveryClient discoveryClient;
	@RequestMapping(value="say/{name}/{text}")
	public String say(@PathVariable String name,@PathVariable String text){
//		@SuppressWarnings("deprecation")
//		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
//		System.out.println(instance.getHost()+instance.getPort()+instance.getServiceId());
		return helloService.say(name,text);
	}
}
