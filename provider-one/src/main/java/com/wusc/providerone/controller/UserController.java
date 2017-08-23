package com.wusc.providerone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.providerone.service.UserService;

@RestController
@RequestMapping(value="user",produces="application/json")
public class UserController {
	@Autowired
	private UserService helloService;
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping(value="user/{name}",method=RequestMethod.GET)
	public String user(@PathVariable String name){
		@SuppressWarnings("deprecation")
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println(instance.getHost()+instance.getPort()+instance.getServiceId());
		return helloService.say(name);
	}
}
