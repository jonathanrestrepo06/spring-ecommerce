package com.proyecto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

}
