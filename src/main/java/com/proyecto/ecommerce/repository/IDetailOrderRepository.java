package com.proyecto.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.model.DetailOrder;

@Repository
public interface IDetailOrderRepository extends JpaRepository<DetailOrder, Integer>{

}
