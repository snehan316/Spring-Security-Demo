package com.sneha.springsecurity.demo.bankapplication.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "native") // native -> make the DB to generate the ID sequence
	@GenericGenerator(name="native", strategy="native") // to avoid sql error - can't generate customer_seq
	private int id;
	private String email;
	private String pwd;
	private String role;
		
	public Customer() {
		super();
	}
	
	
	public Customer(int id, String email, String pwd, String role) {
		super();
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.role = role;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
