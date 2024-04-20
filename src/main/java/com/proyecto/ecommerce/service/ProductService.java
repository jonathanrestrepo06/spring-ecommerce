package com.proyecto.ecommerce.service;

import java.util.Optional;

import com.proyecto.ecommerce.model.Product;

public interface ProductService {
	
	public Product save(Product product);
	public Optional<Product> get(Integer id);
	public void update(Product product);
	public void delete(Integer id);
}
