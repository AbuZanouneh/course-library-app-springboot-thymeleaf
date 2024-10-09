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
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name", length = 50, nullable = false)
    private String bookName;

    @Column(name = "book_description", length = 250, nullable = false)
    private String description;

    @Column(name = "book_isbn", length = 50, nullable = false, unique = true)
    private String bookIsbn;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name ="author_id")})
    private Set<Author> authors= new HashSet<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name ="category_id")})
    private Set<Category> categories= new HashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name ="publisher_id")})
    private Set<Publisher> publishers= new HashSet<Publisher>();

    public Book(String bookName, String description, String bookIsbn) {
        this.bookName = bookName;
        this.description = description;
        this.bookIsbn = bookIsbn;
    }

    // For Publisher.
    // important note:
    // In a bidirectional many-to-many relationship, you need to update both sides of the association to keep your data consistent.
    // Otherwise, you could end up with error's and Inconsistency.
    public void removePublisher(Publisher publisher){
        // Remove publisher from the Book's set of publishers.
        this.publishers.remove(publisher);
        // Remove the Book from the Publisher's set of books.
        publisher.getBooks().remove(publisher); // you can add (this) instead of (publisher).
    }

    public void addPublisher(Publisher publisher){
        // add publisher to the Book's set of publishers - in Book Entity.
        this.publishers.add(publisher);
        // add the Book to the Publisher's set of books - in Publisher Entity.
        publisher.getBooks().add(this);
    }

    // For Author.
    public void removeAuthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(author);
    }
    public void addAuthor(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }


    // For Category.
    public void removeCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(category);
    }
    public void addCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }



}
