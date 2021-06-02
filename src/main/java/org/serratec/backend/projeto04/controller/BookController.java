package org.serratec.backend.projeto04.controller;

import java.util.List;

import org.serratec.backend.projeto04.entity.BookEntity;
import org.serratec.backend.projeto04.exception.BookNotFoundException;
import org.serratec.backend.projeto04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping("/livro")
	public ResponseEntity<List<BookEntity>> findAll() {
		return new ResponseEntity<List<BookEntity>>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping("/livro/")
	public ResponseEntity<List<BookEntity>> orderBy(@RequestParam String order){
		return new ResponseEntity<List<BookEntity>>(service.orderBy(order),HttpStatus.OK);
	}
	@GetMapping("/livro/{id}")	
	public ResponseEntity<BookEntity> findById(@PathVariable Integer id) throws BookNotFoundException {
		return new ResponseEntity<BookEntity>(service.getById(id),HttpStatus.OK);
	}
	@PostMapping("/livro")
	public ResponseEntity<String> create(@RequestBody BookEntity book) {
		service.create(book);
		return new ResponseEntity<String>("Criado com sucesso!",HttpStatus.OK);
		
	}
	@PutMapping("/livro/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody BookEntity book) throws BookNotFoundException {
		service.update(id, book);
		return new ResponseEntity<String>("Alterado com sucesso.",HttpStatus.OK);
	}
	@DeleteMapping("/livro/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws BookNotFoundException {
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso!",HttpStatus.OK);
	}
	
}
