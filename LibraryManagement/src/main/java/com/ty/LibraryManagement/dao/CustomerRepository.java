package com.ty.LibraryManagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ty.LibraryManagement.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	 @Query("SELECT u FROM Customer u WHERE u.name = :name")
	    public Customer getCustomerByName(@Param("name") String name);

}
