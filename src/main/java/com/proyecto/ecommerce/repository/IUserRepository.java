package com.proyecto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	
}
