package com.ty.LibraryManagement.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phno;

	@OneToMany(mappedBy = "borrowedBy")
	private List<BooksData> books;
	public List<BooksData> getBooks() {
		return books;
	}
	public void setBooks(List<BooksData> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phno=" + phno + ", books=" + books + "]";
	}
	public Customer() {

	}
	
	
	

}
