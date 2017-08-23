package com.wusc.providertwo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String say(String name) {
		return "我是"+name;
	}
	
}
