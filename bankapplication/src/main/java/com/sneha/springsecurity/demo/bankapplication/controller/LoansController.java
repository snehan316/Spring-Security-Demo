package com.sneha.springsecurity.demo.bankapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

	@GetMapping("/loans")
	public String myAccount() {
		return "Loan Info";
	}
}
