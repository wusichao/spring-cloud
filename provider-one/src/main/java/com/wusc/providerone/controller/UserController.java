package com.wusc.providerone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.providerone.service.UserService;

@RestController
@RequestMapping(value="user",produces="application/json")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping(value="user/{name}",method=RequestMethod.GET)
	public ResponseEntity<ModelMap> user(@PathVariable String name){
		@SuppressWarnings("deprecation")
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println(instance.getHost()+instance.getPort()+instance.getServiceId());
		return ResponseEntity.ok(new ModelMap().addAttribute("data", userService.say(name)).addAttribute("by", instance.getPort()+instance.getServiceId()));
	}
}
