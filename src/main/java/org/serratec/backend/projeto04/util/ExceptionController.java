package org.serratec.backend.projeto04.util;

import org.serratec.backend.projeto04.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> handlerBookException(BookNotFoundException  exception){
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
	
}
