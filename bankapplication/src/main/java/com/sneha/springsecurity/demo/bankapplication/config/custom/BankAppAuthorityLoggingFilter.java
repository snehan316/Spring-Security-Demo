package com.sneha.springsecurity.demo.bankapplication.config.custom;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class BankAppAuthorityLoggingFilter implements Filter{

	private final Logger log = Logger.getLogger(BankAppAuthorityLoggingFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			log.info("User " + authentication.getName() + " is successfully authenticated");
		}
		
		chain.doFilter(request, response);
	} 
}
