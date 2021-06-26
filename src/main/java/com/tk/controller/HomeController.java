package com.tk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tk.dto.BookDto;
import com.tk.service.BookService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String homte(Model model) {
	  List<BookDto> bookList = bookService.listAll();
	  model.addAttribute("bookList", bookList);
	  return "home";
	}
}
