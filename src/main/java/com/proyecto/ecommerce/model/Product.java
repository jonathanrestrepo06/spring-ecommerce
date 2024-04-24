package com.proyecto.ecommerce.model;



import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private byte[] image;
	private double price;
	private int cuantity;
	
	@ManyToOne
	private User user;
	
	



	public Product(Integer id, String name, String description, byte[] image, double price, int cuantity, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.cuantity = cuantity;
		this.user = user;
	}
	
	

	public Product(Integer id, String name, String description, double price, int cuantity, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cuantity = cuantity;
		this.user = user;
	}



	public Product() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", image="
				+ Arrays.toString(image) + ", price=" + price + ", cuantity=" + cuantity + ", user=" + user + "]";
	}
	
	
}
