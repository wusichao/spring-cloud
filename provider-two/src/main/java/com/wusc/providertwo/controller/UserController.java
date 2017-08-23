package com.wusc.providertwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wusc.providertwo.service.UserService;

@RestController
@RequestMapping(value="user",produces="application/json")
public class UserController {
	@Autowired
	private UserService helloService;
	@RequestMapping(value="user/{name}",method=RequestMethod.GET)
	public String user(@PathVariable String name){
		return helloService.say(name);
	}
}
