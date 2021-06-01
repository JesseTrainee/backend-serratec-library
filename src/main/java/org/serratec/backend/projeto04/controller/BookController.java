package org.serratec.backend.projeto04.controller;

import java.util.List;

import org.serratec.backend.projeto04.entity.BookEntity;
import org.serratec.backend.projeto04.exception.BookNotFoundException;
import org.serratec.backend.projeto04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping
	public List<BookEntity> findAll() {
		return service.getAll();
	}
	@GetMapping("{id}")	
	public BookEntity findById(@PathVariable Integer id) throws BookNotFoundException {
		return service.getById(id);
	}
	@PostMapping
	public String create(@RequestBody BookEntity book) {
		service.create(book);
		return "Criado com sucesso";
	}
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id, @RequestBody BookEntity book) throws BookNotFoundException {
		service.update(id, book);
		return "Alterado com sucesso.";
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}