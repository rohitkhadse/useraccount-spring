package com.rohitkhadse.api.controller;

import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohitkhadse.api.constant.URI;
import com.rohitkhadse.api.entity.User;
import com.rohitkhadse.api.service.UserService;

@Component
@ResponseBody

@RestController
@RequestMapping(value = URI.USERS)
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
	public User findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	

	@RequestMapping(method = RequestMethod.POST )
	public User create(@RequestBody User user){
		return service.create(user);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
	public User update(@PathVariable("id")String id,@RequestBody User user){
		return service.update(id, user);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
	public void delete(String id){
		service.delete(id);
	}
}
