package com.wusc.consumerone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.consumerone.service.HelloService;

@RestController
@RequestMapping(produces="application/json")
public class HelloController {
	@Autowired
	private HelloService helloService;
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping(value="say/{name}/{text}")
	public ResponseEntity<ModelMap> say(@PathVariable String name,@PathVariable String text){
		@SuppressWarnings("deprecation")
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println(instance.getHost()+instance.getPort()+instance.getServiceId());
		return ResponseEntity.ok(new ModelMap().addAttribute("data", helloService.say(name,text)).addAttribute("by", instance.getPort()+instance.getServiceId()));
	}
}
