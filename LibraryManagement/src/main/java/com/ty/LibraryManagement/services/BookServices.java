package com.ty.LibraryManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.LibraryManagement.dao.BooksRepository;
import com.ty.LibraryManagement.dao.CustomerRepository;
import com.ty.LibraryManagement.entity.BooksData;
import com.ty.LibraryManagement.entity.Customer;

@Component
public class BookServices {
	
	@Autowired
	BooksRepository booksRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<BooksData> getAllData()
	{
		List<BooksData> list=(List<BooksData>) booksRepository.findAll();
		return list;
	}
	
	
	public BooksData saveBook(BooksData booksData)
	{
		BooksData booksData2=this.booksRepository.save(booksData);
		return booksData2;
	}
	
	public void deleteBook(int id)
	{
		booksRepository.deleteById(id);
	}
	
	public BooksData updateBook(BooksData booksData,int id)
	{
		//booksData.setId(id);
		BooksData booksData2=null;
		Optional<BooksData> optional=booksRepository.findById(id);
		if(optional.isEmpty())
		{
			return booksData;
		}
		booksData2=this.booksRepository.save(booksData);
		return booksData2;
	}
	
	public Optional<BooksData> getBookById(int id)
	{
		Optional<BooksData> optional=this.booksRepository.findById(id);
		return optional;
	}
	
	public BooksData getBookByName(String name)
	{
		BooksData booksData=booksRepository.getBookByName(name);
		if(booksData!=null)
		{
		return booksData;
		}
		return null;
	}
	
	
	public BooksData borrowBook(int bookid,int customerId)
	{
		BooksData book=booksRepository.findById(bookid).orElse(null);
		Customer customer=customerRepository.findById(customerId).orElse(null);
		
		if(book!=null && !book.isBorrowed() && customer!=null)
		{
			book.setBorrowedBy(customer);
			book.setBorrowed(true);
			return booksRepository.save(book);
		}
		return null;
	}
	
	public BooksData returnBook(int bookId)
	{
		BooksData book=booksRepository.findById(bookId).orElse(null);
		if(book!=null && book.isBorrowed())
		{
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			return booksRepository.save(book);
		}
		return null;
	}
	
	

}
