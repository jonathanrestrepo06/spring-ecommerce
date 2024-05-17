package com.proyecto.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.model.Order;
import com.proyecto.ecommerce.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderRepository orderRepository;
	@Override
	public Order save(Order order) {
		
		return orderRepository.save(order);
	}

}
