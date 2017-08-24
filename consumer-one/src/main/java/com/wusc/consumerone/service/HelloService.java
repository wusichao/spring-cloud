package com.wusc.consumerone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private UserServiceI userService;
//	@HystrixCommand(defaultFallback="fallback")
	public String say(String name, String text) {
		
		return text+"by"+userService.user(name);
	}
//	public String fallback(){
//		return "error";
//	}
}
