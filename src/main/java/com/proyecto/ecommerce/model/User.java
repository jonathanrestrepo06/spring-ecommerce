package com.proyecto.ecommerce.model;

public class User {
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String address;
	private String telephone;
	private String type;
	private String password;
	
	
	
	public User(Integer id, String name, String username, String email, String address, String telephone,
			String type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.type = type;
		this.password = password;
	}
	
		
	public User() {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", address="
				+ address + ", telephone=" + telephone + ", type=" + type + ", password=" + password + "]";
	}
	
	

}
