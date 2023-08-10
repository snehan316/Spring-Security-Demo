package com.sneha.springsecurity.demo.bankapplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sneha.springsecurity.demo.bankapplication.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

	List<Customer> findByEmail(String email);
}
