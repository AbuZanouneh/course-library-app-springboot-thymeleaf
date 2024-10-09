package com.ats.courselibrary.repository;

import com.ats.courselibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//Data Access layer
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
