package com.sneha.springsecurity.demo.bankapplication.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.sneha.springsecurity.demo.bankapplication.config.custom.BankAppAuthorityLoggingFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.securityContext().requireExplicitSave(false).and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
		.cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("*"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}
		})
		.and().csrf().disable().addFilterAfter(new BankAppAuthorityLoggingFilter(), BasicAuthenticationFilter.class)
		.authorizeHttpRequests()
//		.requestMatchers("/accounts").hasAuthority("VIEWACCOUNT")
//		.requestMatchers("/balance").hasAuthority("VIEWBALANCE")
//		.requestMatchers("/cards").hasAuthority("VIEWCARDS")
//		.requestMatchers("/loans").hasAuthority("VIEWLOAN")
		.requestMatchers("/accounts").hasRole("USER")
		.requestMatchers("/balance").hasAnyRole("USER","ADMIN")
		.requestMatchers("/cards").hasRole("USER")
		.requestMatchers("/loans").hasRole("USER")
		.requestMatchers("/customers").authenticated()
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