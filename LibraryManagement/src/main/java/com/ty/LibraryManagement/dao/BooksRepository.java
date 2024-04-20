package com.ty.LibraryManagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ty.LibraryManagement.entity.BooksData;

public interface BooksRepository extends CrudRepository<BooksData, Integer> {
	
    @Query("SELECT u FROM BooksData u WHERE u.book_name = :name")
    public BooksData getBookByName(@Param("name") String name);

}
