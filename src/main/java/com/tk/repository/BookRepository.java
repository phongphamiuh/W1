package com.tk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tk.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
