package com.tk.dto;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BookRequest {
	private Long bookID;

    @NotEmpty
    private String bookName;
    
    private String author;
   
    @NotNull
    private int publishYear;
    
    private String rating;
    
    @Basic(fetch= FetchType.LAZY)
    @Lob
    private byte[] image;
}
