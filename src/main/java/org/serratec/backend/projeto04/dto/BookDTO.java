package org.serratec.backend.projeto04.dto;

import java.time.LocalDate;

public class BookDTO {
	
	private String title;	
	private String author;
	private String Type;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
}
