package com.rohitkhadse.api.service.impl;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rohitkhadse.api.entity.User;
import com.rohitkhadse.api.exception.BadRequestException;
import com.rohitkhadse.api.exception.NotFoundException;
import com.rohitkhadse.api.repository.UserRepository;
import com.rohitkhadse.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(String id) {
		User existing  = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User with id "+ id + "does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing  = repository.findByEmail(user.getEmail());
		
		if (existing != null ) {
			throw new BadRequestException("User with email "+ user.getEmail() + " already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing  = repository.findOne(id);
		
		if (existing != null ) {
			throw new NotFoundException("User with id "+ id + "does not exist");
		}
		
		return repository.update( user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing  = repository.findOne(id);
		
		if (existing != null ) {
			throw new NotFoundException("User with id "+ id + "does not exist");
		}
		repository.delete(existing);
	}

}
