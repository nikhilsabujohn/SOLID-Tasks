package com.ty.LibraryManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.LibraryManagement.entity.BooksData;
import com.ty.LibraryManagement.entity.Customer;
import com.ty.LibraryManagement.services.CustomerServices;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServices services;
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> list=services.getAllData();
		if(list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) 
	{
		Optional<Customer> optional=services.getCustomerById(id);
		if(optional.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(Optional.of(optional));
	}
	
	@GetMapping("/customer/find/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name)
	{
		Customer customer=services.getCustomerByName(name);
		if(customer!=null)
		{
			return ResponseEntity.ok(customer);
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer)
	{
		Customer customer2=services.savecustomer(customer);
		if(customer2==null)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(customer2);
	}
	
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") int id)
	{
		services.deleteCustomer(id);
	}
	
	
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		Customer customer2=services.updateCustomer(customer, id);
		if(customer2==null)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok(customer2);
	}
	
	
	
	

}
