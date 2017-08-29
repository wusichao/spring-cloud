package com.wusc.providerone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.providerone.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RefreshScope
@RestController
@RequestMapping(produces="application/json")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Value("${from}")
	private String from;
	@ApiOperation(value="根据名字获取用户", response=String.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
	})
	@RequestMapping(value="user/{name}",method=RequestMethod.GET)
	public ResponseEntity<ModelMap> user(@PathVariable String name){
		@SuppressWarnings("deprecation")
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println(instance.getHost()+instance.getPort()+instance.getServiceId());
		return ResponseEntity.ok(new ModelMap().addAttribute("data", userService.say(name)).addAttribute("by", instance.getPort()+instance.getServiceId()));
	}
	@RequestMapping(value = "from",method = RequestMethod.GET)
	public ResponseEntity<ModelMap> from(){

	return ResponseEntity.ok(new ModelMap().addAttribute("data",from));
	}
}
