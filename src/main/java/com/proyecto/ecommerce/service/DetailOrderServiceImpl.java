package com.proyecto.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.model.DetailOrder;
import com.proyecto.ecommerce.repository.IDetailOrderRepository;

@Service
public class DetailOrderServiceImpl implements IDetailOrderService{
	@Autowired
	private IDetailOrderRepository detailOrderRepository;
	
	@Override
	public DetailOrder save(DetailOrder detailOrder) {
		
		return detailOrderRepository.save(detailOrder);
	}

}
