package com.sneha.springsecurity.demo.bankapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.springsecurity.demo.bankapplication.entity.Customer;
import com.sneha.springsecurity.demo.bankapplication.repo.CustomerRepository;

@Service
public class CustomerService{

	@Autowired
	private CustomerRepository repo;
	
//	
//	public List<Customer> getCustomers(){
//		return repo.findAll();
//	}
	
	public List<Customer> getCustomerByEmail(String email) {
		List<Customer> customers =  repo.findByEmail(email);
		return customers;
	}
}
