package com.ty.LibraryManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ty.LibraryManagement.dao.CustomerRepository;
import com.ty.LibraryManagement.entity.Customer;

@Component
public class CustomerServices {

@Autowired	
CustomerRepository customerRepository;


public List<Customer> getAllData()
{
	List<Customer> list=(List<Customer>) customerRepository.findAll();
	return list;
}

public Customer savecustomer(Customer customer)
{
	Customer customer2=this.customerRepository.save(customer);
	return customer2;
}

public void deleteCustomer(int id)
{
	customerRepository.deleteById(id);
}

public Customer updateCustomer(Customer customer,int id)
{
	//booksData.setId(id);
	Customer customer2=null;
	Optional<Customer> optional=customerRepository.findById(id);
	if(optional.isEmpty())
	{
		return customer;
	}
	customer2=this.customerRepository.save(customer);
	return customer2;
}

public Optional<Customer> getCustomerById(int id)
{
	Optional<Customer> optional=this.customerRepository.findById(id);
	return optional;
}

public Customer getCustomerByName(String name)
{
	Customer customer=customerRepository.getCustomerByName(name);
	if(customer!=null)
	{
	return customer;
	}
	return null;
}




}
