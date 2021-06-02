package org.serratec.backend.projeto04.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto04.entity.BookEntity;
import org.serratec.backend.projeto04.exception.BookNotFoundException;
import org.serratec.backend.projeto04.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public void create(BookEntity book) {
		repository.save(book);
		
	}
	
		public void update(Integer id,BookEntity bookTemp) throws BookNotFoundException {
		BookEntity book = getById(id);	
		if(bookTemp.getTitle() != null) {
			book.setTitle(bookTemp.getTitle());
		}
		if(bookTemp.getAuthor() != null) {
			book.setAuthor(bookTemp.getAuthor());
		}
		repository.save(book);
	}
	
	public List<BookEntity> getAll() {
		return repository.findAll(Sort.by("publicationDate"));
	}
	
	public BookEntity getById(Integer id) throws BookNotFoundException {
		Optional<BookEntity> book = repository.findById(id);
		if(book.isEmpty()) {
			throw new BookNotFoundException("Não existe livro com esse id!");
		}
		return book.get();
		
	}
	public void delete(Integer id) throws BookNotFoundException {
		Optional<BookEntity> book = repository.findById(id);
		if(book.isEmpty()) {
			throw new BookNotFoundException("Não existe livro com esse id!");
		}
		repository.deleteById(id);
	}
	
	public List<BookEntity> orderBy(String orderType){
		return repository.findAll(Sort.by(orderType));
	}
	
}
