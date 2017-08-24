package com.wusc.consumerone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
@Service
public class UserService implements UserServiceI{

	@Override
	public ResponseEntity<ModelMap> user(String name) {
		return ResponseEntity.ok(new ModelMap().addAttribute("error","error"));
	}

}
