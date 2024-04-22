package com.ty.LibraryManagement.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ty.LibraryManagement.dao.BooksRepository;
import com.ty.LibraryManagement.entity.BooksData;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Optional;

public class BookDeleteTest {

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BookServices bookService; 

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteBook() {
        int id = 1;
        BooksData book = new BooksData();
        when(booksRepository.findById(id)).thenReturn(Optional.of(book));

        boolean isDeleted = bookService.deleteBook(id);
        assertTrue(isDeleted);

        Mockito.verify(booksRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testDeleteBookNotFound() {
        int id = 1;
        when(booksRepository.findById(id)).thenReturn(Optional.empty());

        boolean isDeleted = bookService.deleteBook(id);
        assertFalse(isDeleted);

        Mockito.verify(booksRepository, Mockito.times(0)).deleteById(id);
    }
}