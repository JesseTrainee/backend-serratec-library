package org.serratec.backend.projeto04.mapper;

import org.serratec.backend.projeto04.dto.BookDTO;
import org.serratec.backend.projeto04.entity.BookEntity;

public class BookMapper {	
	public BookEntity toEntity(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setAuthor(bookDTO.getAuthor());
		bookEntity.setTitle(bookDTO.getTitle());
		bookEntity.setType(bookDTO.getType());
		return bookEntity;		
	}
	public BookDTO toDTO(BookEntity bookEntity) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(bookEntity.getAuthor());
		bookDTO.setTitle(bookEntity.getTitle());
		bookDTO.setType(bookEntity.getType());
		return bookDTO;
	}
}
