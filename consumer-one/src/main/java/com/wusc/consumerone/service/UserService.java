package com.wusc.consumerone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
@Component
public class UserService implements UserServiceI{

	@Override
	public ResponseEntity<ModelMap> user(String name) {
		return ResponseEntity.ok(new ModelMap().addAttribute("error","hello熔断 "));
	}

}
