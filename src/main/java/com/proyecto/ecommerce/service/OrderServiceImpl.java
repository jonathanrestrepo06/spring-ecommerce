package com.proyecto.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public List<Order> findAll() {
		
		return orderRepository.findAll();
	}
	
	public String generateNumberOrder() {
		
		int number = 0;
		String numberConcat = "";
		
		List<Order> orders = findAll();
		List<Integer> numbers = new ArrayList<>();
		
		orders.stream().forEach(o -> numbers.add(Integer.parseInt(o.getNumber())));
		
		if(orders.isEmpty()) {
			number = 1;
		}else {
			number = numbers.stream().max(Integer::compare).get();
			number++;
		}
		
		if(number<10) {
			numberConcat = "000000000" + String.valueOf(number);
		}else if (number<100) {
			numberConcat = "00000000" + String.valueOf(number);
		}else if (number<1000) {
		numberConcat = "0000000" + String.valueOf(number);
	    }else if (number<10000) {
		numberConcat = "000000" + String.valueOf(number);
	    }
		
		
		return numberConcat;
	}

}
