package com.ty.LibraryManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.LibraryManagement.dao.BooksRepository;
import com.ty.LibraryManagement.entity.BooksData;

@SpringBootTest
public class BookSaveTest {
	
    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookServices bookServices;
	
	
    @Test
    public void testSaveBook() {

        BooksData book = new BooksData();
        when(booksRepository.save(any(BooksData.class))).thenReturn(book);

        BooksData savedBook = bookServices.saveBook(book);

        assertEquals(book, savedBook);
        verify(booksRepository, times(1)).save(book);
    }

}
