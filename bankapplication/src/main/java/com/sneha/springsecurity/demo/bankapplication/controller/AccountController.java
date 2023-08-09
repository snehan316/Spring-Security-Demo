package com.sneha.springsecurity.demo.bankapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/accounts")
	public String myAccount() {
		return "Account Info";
	}
}
