package com.ty.LibraryManagement.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BooksData")
public class BooksData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String book_name; 
	private String author;
	private double price;
	private boolean borrowed;
	@JoinColumn()
	@ManyToOne()
	private Customer borrowedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	public Customer getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(Customer borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	public BooksData(int id, String book_name, String author, double price, boolean borrowed, Customer borrowedBy) {
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.borrowed = borrowed;
		this.borrowedBy = borrowedBy;
	}
	public BooksData() {

	}
	@Override
	public String toString() {
		return "BooksData [id=" + id + ", book_name=" + book_name + ", author=" + author + ", price=" + price
				+ ", borrowed=" + borrowed + ", borrowedBy=" + borrowedBy + "]";
	}
	
	
	
}