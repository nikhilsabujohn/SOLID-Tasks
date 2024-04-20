package com.ty.LibraryManagement.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.LibraryManagement.dao.BooksRepository;

@SpringBootTest
public class BookDeleteTest {
    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookServices bookServices;
    
    

    @Test
    public void testDeleteBook() {

        int id = 1;
        bookServices.deleteBook(id);
        verify(booksRepository, times(1)).deleteById(id);
    }

}
