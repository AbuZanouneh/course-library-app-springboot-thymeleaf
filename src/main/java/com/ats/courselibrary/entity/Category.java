package com.ats.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_name", length = 50, nullable = false, unique = true)
    private String  categoryName;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
