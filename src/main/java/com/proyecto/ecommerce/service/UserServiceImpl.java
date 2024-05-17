package com.proyecto.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.model.User;
import com.proyecto.ecommerce.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public Optional<User> findById(Integer id) {
		
		return userRepository.findById(id);
	}



}
