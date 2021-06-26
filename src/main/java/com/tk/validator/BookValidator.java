package com.tk.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tk.model.Book;
@Component
public class BookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz==Book.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Book book=(Book)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "error.bookName", "Yêu cầu");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "error.author", "Yêu cầu");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishYear", "error.publishYear", "Yêu cầu");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rating", "error.rating", "Yêu cầu");
     //   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "error.image", "Yêu cầu");
        int publishYear = book.getPublishYear();
        if(publishYear < 1900 || publishYear >2018) {
        	errors.rejectValue("publishYear", "Năm trong khoảng 1900 tới 2018");
        }
        String bookName = book.getBookName();
//        Pattern pattern = Pattern.compile("");
//        Matcher test = pattern.matcher(bookName);
//        if(!test.matches()) {
//        	errors.rejectValue("publishYear", "Tên tác giả sai");
//        }
        
	}

}
