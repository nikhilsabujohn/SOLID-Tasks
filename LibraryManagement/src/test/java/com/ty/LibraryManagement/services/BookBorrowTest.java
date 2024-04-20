package com.ty.LibraryManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.LibraryManagement.dao.BooksRepository;
import com.ty.LibraryManagement.dao.CustomerRepository;
import com.ty.LibraryManagement.entity.BooksData;
import com.ty.LibraryManagement.entity.Customer;

@SpringBootTest
public class BookBorrowTest {
	
	  @Mock
	    private BooksRepository booksRepository;

	    @Mock
	    private CustomerRepository customerRepository;

	    @InjectMocks
	    private BookServices bookServices;

	    @Test
	    public void testBorrowBook() {

	        int bookId = 1;
	        int customerId = 1;
	        BooksData book = new BooksData();
	        Customer customer = new Customer();
	        when(booksRepository.findById(bookId)).thenReturn(Optional.of(book));
	        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
	        when(booksRepository.save(any(BooksData.class))).thenReturn(book);


	        BooksData borrowedBook = bookServices.borrowBook(bookId, customerId);

	        assertEquals(book, borrowedBook);
	        assertTrue(borrowedBook.isBorrowed());
	        assertEquals(customer, borrowedBook.getBorrowedBy());
	    }


}
