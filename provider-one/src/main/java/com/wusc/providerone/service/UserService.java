package com.wusc.providerone.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String say(String name) {
		int sleep= new Random().nextInt(1500);
		System.out.println("user sleep:"+sleep);
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "我是"+name+"--------user sleep:"+sleep;
	}
	
}
