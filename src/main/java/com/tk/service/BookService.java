package com.tk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tk.dto.BookDto;
import com.tk.model.Book;
import com.tk.repository.BookRepository;
@Component
public class BookService {
	
	@Autowired 
	BookRepository repo;
	
	public void save(Book book) {
		repo.save(book);
	}
	
	public List<BookDto> listAll() {
		List<BookDto> list = new ArrayList<>();
		repo.findAll().forEach(book1->{
			BookDto bookDto= new BookDto();
			bookDto.setAuthor(book1.getAuthor());
			bookDto.setBookID(book1.getBookID());
			bookDto.setBookName(book1.getBookName());
			bookDto.setPublishYear(book1.getPublishYear());
			bookDto.setRating(book1.getRating());
			
			list.add(bookDto);
		});
		return list;
	}	
	
	public Book get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
