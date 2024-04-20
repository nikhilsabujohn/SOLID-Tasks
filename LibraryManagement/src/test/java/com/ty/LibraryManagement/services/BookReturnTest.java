package com.ty.LibraryManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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

@SpringBootTest
public class BookReturnTest {
	  @Mock
	    private BooksRepository booksRepository;

	    @Mock
	    private CustomerRepository customerRepository;

	    @InjectMocks
	    private BookServices bookServices;
	
	    @Test
	    public void testReturnBook() {

	        int bookId = 1;
	        BooksData book = new BooksData();
	        book.setBorrowed(true);
	        when(booksRepository.findById(bookId)).thenReturn(Optional.of(book));
	        when(booksRepository.save(any(BooksData.class))).thenReturn(book);

	        BooksData returnedBook = bookServices.returnBook(bookId);

	        assertEquals(book, returnedBook);
	        assertFalse(returnedBook.isBorrowed());
	        assertNull(returnedBook.getBorrowedBy());
	    }

}
