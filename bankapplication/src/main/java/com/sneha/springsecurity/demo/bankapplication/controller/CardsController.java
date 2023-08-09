package com.sneha.springsecurity.demo.bankapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("/cards")
	public String myAccount() {
		return "Cards Info";
	}

}
