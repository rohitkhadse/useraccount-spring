package com.rohitkhadse.api.service;

import java.util.List;

import com.rohitkhadse.api.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findOne(String id);
	
	public User create(User user);
	
	public User update(String id, User user);
	
	public void delete(String id);
}
