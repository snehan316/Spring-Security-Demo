package com.sneha.springsecurity.demo.bankapplication.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/accounts","/cards","/loans","/balance","/customers").authenticated()
		.requestMatchers("/contact","/notices","/register").permitAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	/*****************************************************************************/
	
    /*
      // Below code will permit all the requests without authentication - Not recommended for production
	     http.authorizeHttpRequests().anyRequest().permitAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build(); 
	*/
	
	/*****************************************************************************/
	
	 /*
     //  Below code will deny all the requests without authentication  - Not recommended for production	
	   http.authorizeHttpRequests().anyRequest().denyAll()
		.and().formLogin()
		.and().httpBasic();
		
		return http.build(); 
	*/
	
	/*****************************************************************************/
	/* In-Memory User-details*/
	
	/* @Bean
	   public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder()
								.username("admin")
								.password("admin-password")
								.authorities("admin")
								.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
								.username("user")
								.password("user-pass")
								.authorities("read")
								.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	} */
	
		

	/*****************************************************************************/
	/* In-Memory User-details with No-ops password encoder -> password stored in Plaintext*/

//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails admin = User.withUsername("admin")
//								.password("admin-pass")
//								.authorities("admin")
//								.build();
//		
//		UserDetails user = User.withUsername("user")
//								.password("user-pass")
//								.authorities("read")
//								.build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//	}
	
	/*****************************************************************************/
	/* JDBC User-details with No-ops password encoder -> password stored in Plaintext*/
//	@Bean
//	public UserDetailsManager userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	
	
	
	
}