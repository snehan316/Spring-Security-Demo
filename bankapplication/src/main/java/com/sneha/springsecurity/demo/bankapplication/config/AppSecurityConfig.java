package com.sneha.springsecurity.demo.bankapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers("/accounts","/cards","/loans").authenticated()
		.requestMatchers("/contact","/notices").permitAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build();
	}
	
    /*
     *  Below code will permit all the requests without authentication - Not recommended for production
	/*    http.authorizeHttpRequests().anyRequest().permitAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build(); 
	*/
	
	 /*
     *  Below code will deny all the requests without authentication  - Not recommended for production
	 */	
		
	/*    http.authorizeHttpRequests().anyRequest().denyAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build(); 
	*/
	
	
}