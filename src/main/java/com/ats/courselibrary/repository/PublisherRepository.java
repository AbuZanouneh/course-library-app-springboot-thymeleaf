package com.ats.courselibrary.repository;

import com.ats.courselibrary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

//Data Access layer
public interface PublisherRepository extends JpaRepository <Publisher, Long> {
}
