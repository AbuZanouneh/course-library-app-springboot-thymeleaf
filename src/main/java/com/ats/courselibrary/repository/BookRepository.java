package com.ats.courselibrary.repository;

import com.ats.courselibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// Data Access Layer.
public interface BookRepository extends JpaRepository<Book, Long> {
}
