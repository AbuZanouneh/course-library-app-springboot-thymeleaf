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
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(name = "publisher_name", length = 50, nullable = false, unique = true)
    private String publisherName;

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }
}
