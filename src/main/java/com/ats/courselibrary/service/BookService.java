package com.ats.courselibrary.service;

import com.ats.courselibrary.entity.Book;
import com.ats.courselibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service Layer.
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    // List all Books.
    public Book findBookById(Long bookId){
        Book book;
        //findById() return optional so you must add condition () and throw exception if the data not found.
        book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }

    // Create a new Book.
    public void createBook(Book book){
         bookRepository.save(book);
    }

    // Update an exist Book.
    public void updateBook(Book book){
        bookRepository.save(book);
    }

    // Delete a Book.
    public void deleteBook(Long bookId){
        //You need to check first before deleting the book if it is existing or not.
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.deleteById(book.getBookId());
    }



}
