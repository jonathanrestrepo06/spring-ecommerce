package com.proyecto.ecommerce.service;

import java.util.List;

import com.proyecto.ecommerce.model.Order;

public interface IOrderService {
	List<Order> findAll();
	Order save(Order order);
	String generateNumberOrder();
}
