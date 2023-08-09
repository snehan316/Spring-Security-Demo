package com.sneha.springsecurity.demo.bankapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

	@GetMapping("/contact")
	public String myAccount() {
		return "Contact Info";
	}
}
