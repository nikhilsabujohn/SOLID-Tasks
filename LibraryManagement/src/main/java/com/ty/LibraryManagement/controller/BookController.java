package com.ty.LibraryManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.ty.LibraryManagement.entity.BooksData;
import com.ty.LibraryManagement.services.BookServices;

import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class BookController {
	
	@Autowired
	BookServices services;
	
	
	@GetMapping("/book")
	public ResponseEntity<Object> getAllBooks()
	{
		List<BooksData> list=services.getAllData();
		if(list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Relevent Data");
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable("id") int id) 
	{
		Optional<BooksData> optional=services.getBookById(id);
		if(optional.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Data Found");
		}
		return ResponseEntity.ok(Optional.of(optional));
	}
	
	@GetMapping("/book/search/{name}")
	public ResponseEntity<BooksData> getBookByName(@PathVariable("name") String name)
	{
		BooksData booksData=services.getBookByName(name);
		if(booksData!=null)
		{
			return ResponseEntity.ok(booksData);
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	@PostMapping("/book")
	public ResponseEntity<Object> saveBook(@RequestBody BooksData booksData)
	{
		BooksData booksData2=services.saveBook(booksData);
		if(booksData2==null)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(booksData2);
	}
	
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable("id") int id)
	{
		
		boolean flag=services.deleteBook(id);
		if(flag==true)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data Deleted");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data not found");
	}
	
	
	@PutMapping("/book/{id}")
	public ResponseEntity<BooksData> updateBook(@PathVariable("id") int id, @RequestBody BooksData booksData) {
		BooksData booksData2=services.updateBook(booksData, id);
		if(booksData2==null)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok(booksData2);
	}
	
	@PostMapping("/book/borrow/{bookId}/{userId}")
	public ResponseEntity<BooksData> borrowBook(@PathVariable("bookId") int bookId,@PathVariable("userId") int userId)
	{
		BooksData book=services.borrowBook(bookId, userId);
		if(book!=null)
		{
			return ResponseEntity.ok(book);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/book/return/{bookid}")
	public ResponseEntity<BooksData> returnBook(@PathVariable("bookid") int id) {
		BooksData booksData=services.returnBook(id);
		if(booksData!=null)
		{
			return ResponseEntity.ok(booksData);
		}
		return ResponseEntity.badRequest().build();
	}
	
	 
	
	
	
	
	

}
