package com.ty.LibraryManagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.LibraryManagement.dao.BooksRepository;
import com.ty.LibraryManagement.entity.BooksData;

@SpringBootTest
public class BookGetAllDataTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookServices bookServices;

    @Test
    public void testGetAllData() {
        BooksData book1 = new BooksData();
        BooksData book2 = new BooksData();
        List<BooksData> expectedBooks = Arrays.asList(book1, book2);
        when(booksRepository.findAll()).thenReturn(expectedBooks);


        List<BooksData> actualBooks = bookServices.getAllData();


        assertEquals(expectedBooks, actualBooks);
    }
    
}


