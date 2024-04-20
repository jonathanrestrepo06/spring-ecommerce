package com.proyecto.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private Date dateCreated;
	private Date dateReceived;
	private double total;
	
	@ManyToOne
	private User user;
	
	@OneToOne(mappedBy = "order")
	private DetailOrder detail;
	
	public Order(Integer id, String number, Date dateCreated, Date dateReceived, double total) {
		super();
		this.id = id;
		this.number = number;
		this.dateCreated = dateCreated;
		this.dateReceived = dateReceived;
		this.total = total;
		
	}

	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public DetailOrder getDetail() {
		return detail;
	}

	public void setDetail(DetailOrder detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", dateCreated=" + dateCreated + ", dateReceived="
				+ dateReceived + ", total=" + total + "]";
	}
	
	
	

}
