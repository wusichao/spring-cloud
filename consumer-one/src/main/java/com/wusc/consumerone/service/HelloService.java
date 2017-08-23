package com.wusc.consumerone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;
	public String say(String name, String text) {
		
		return text+"by"+restTemplate.getForEntity("http://USER-ONE-SERVER/user/user/"+name, String.class).getBody();
	}

}
