package com.proyecto.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.model.Product;
import com.proyecto.ecommerce.repository.IProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private IProductRepository productRepository;
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> get(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
