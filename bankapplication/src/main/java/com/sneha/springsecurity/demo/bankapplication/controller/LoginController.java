package com.sneha.springsecurity.demo.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.springsecurity.demo.bankapplication.entity.Customer;
import com.sneha.springsecurity.demo.bankapplication.repo.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		
		Customer savedCustomer = null;
		ResponseEntity<String> response = null;
		try {
			String hashPwd =passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPwd);
			savedCustomer=customerRepository.save(customer);
			if(savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED).body("User is successfully registered");
			}
		}catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured "+ e.getMessage());
		}
		
		
		return response;
	}
}
