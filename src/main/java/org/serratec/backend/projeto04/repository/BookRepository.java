package org.serratec.backend.projeto04.repository;

import org.serratec.backend.projeto04.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
