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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(name = "author_name", length = 100, nullable = false, unique = true)
    private String authorName;

    @Column(name = "author_description", length = 250, nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Author(String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }
}
