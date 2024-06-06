package com.proyecto.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details")
public class DetailOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double cuantity;
	private double price;
	private double total;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
	public DetailOrder(Integer id, String name, double cuantity, double price, double total) {
		super();
		this.id = id;
		this.name = name;
		this.cuantity = cuantity;
		this.price = price;
		this.total = total;
	}

	public DetailOrder() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCuantity() {
		return cuantity;
	}

	public void setCuantity(double cuantity) {
		this.cuantity = cuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "DetailOrder [id=" + id + ", name=" + name + ", cuantity=" + cuantity + ", price=" + price + ", total="
				+ total + "]";
	}
	
	

}
