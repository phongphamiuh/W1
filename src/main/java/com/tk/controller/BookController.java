package com.tk.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.tk.dto.BookDto;
import com.tk.model.Book;
import com.tk.service.BookService;
import com.tk.validator.BookValidator;
@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookValidator bookValidator;
	
	@InitBinder
    	public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == Book.class) {
            dataBinder.setValidator(bookValidator);
            // For upload Image.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String newCustomerForm(Map<String, Object> model) {
		Book book= new Book();
		model.put("book", book);
		return "bookForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveCustomer(@Validated @ModelAttribute("book") Book book, BindingResult br,
			HttpServletRequest request) {
		if (br.hasErrors()) {
			return "bookForm";
		}
		byte[] fileContent=null;
		Part muiltipart=null;
		try {		
			muiltipart= request.getPart("image");
//			String fileName=Paths.get(muiltipart.getSubmittedFileName()).getFileName().toString();		
			InputStream inputStream=muiltipart.getInputStream();
			
			fileContent=IOUtils.toByteArray(inputStream);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		book.setImage(fileContent);
		bookService.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/list")
	public String home(Model model) {
	    List<BookDto> bookList = bookService.listAll();
	    System.out.println(bookList);
	    model.addAttribute("bookList", bookList);
	    
	    return "bookList";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Book book) {
		bookService.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("editForm");
		Book book = bookService.get(id);
		mav.addObject("book", book);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
		bookService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping(value="/photo/{id}",method=RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("id")Long id) {
		Book book=bookService.get(id);
		return book.getImage();
	}	

}
