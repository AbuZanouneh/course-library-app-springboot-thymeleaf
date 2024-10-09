package com.ats.courselibrary.repository;


import com.ats.courselibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

//Data Access layer
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
