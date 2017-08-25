package com.wusc.consumerone.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="user",fallback=UserService.class)
public interface UserServiceI {
	@RequestMapping(value="/user/{name}",method=RequestMethod.GET)
	public ResponseEntity<ModelMap> user(@PathVariable("name") String name);
}
