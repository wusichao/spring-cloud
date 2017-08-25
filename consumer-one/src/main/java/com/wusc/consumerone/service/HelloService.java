package com.wusc.consumerone.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private UserServiceI userService;
	public String say(String name, String text) {
		int sleep= new Random().nextInt(1000);
		try {
			
			System.out.println("hello sleep:"+sleep);
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "--------hello sleep:"+sleep+""+text+"by"+userService.user(name);
	}
}
