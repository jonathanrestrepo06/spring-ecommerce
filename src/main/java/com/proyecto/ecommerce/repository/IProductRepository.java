package com.proyecto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
