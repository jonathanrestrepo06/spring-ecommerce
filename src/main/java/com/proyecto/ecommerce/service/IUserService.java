package com.proyecto.ecommerce.service;

import java.util.Optional;

import com.proyecto.ecommerce.model.User;

public interface IUserService {
	
	Optional<User> findById(Integer id);
}
