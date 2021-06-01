package org.serratec.backend.projeto04.repository;

import java.util.List;

import org.serratec.backend.projeto04.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{
	
//	List<BookEntity> findByTitleOrderByTitle(String title);
//	List<BookEntity> findByTitleOrderByType(String title);
//	List<BookEntity> findByTitleOrderByPublicationDate(String title);
//	List<BookEntity> findByOrderByAuthor();
	
}
