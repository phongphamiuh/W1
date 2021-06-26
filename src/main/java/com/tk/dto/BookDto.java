package com.tk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BookDto {
	private Long bookID;

    private String bookName;
    
    private String author;
   
    private int publishYear;
    
    private String rating;
}
