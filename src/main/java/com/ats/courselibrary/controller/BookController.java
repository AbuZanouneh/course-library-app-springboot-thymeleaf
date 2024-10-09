package com.ats.courselibrary.controller;


import com.ats.courselibrary.entity.Book;
import com.ats.courselibrary.entity.Publisher;
import com.ats.courselibrary.service.AuthorService;
import com.ats.courselibrary.service.BookService;
import com.ats.courselibrary.service.CategoryService;
import com.ats.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.PublicKey;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        // System.out.println("book:: " + books);
        return "book";
    }


    @GetMapping("/book/{bookId}")
    public String findBook(@PathVariable Long bookId, Model model){
        Book book = bookService.findBookById(bookId);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/remove-book/{bookId}")
    public String deleteBook(@PathVariable Long bookId, Model model){
        bookService.deleteBook(bookId);
        // To retrieve back all the books and return back to book.html page.
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "book";
    }


    // To display the Data of the book before submit the cahnges.
    @GetMapping("/update-book/{bookId}")
    public String updateBook(@PathVariable Long bookId, Model model){
        Book book = bookService.findBookById(bookId);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());

        return "update-book";
    }


    @PostMapping("/save-update/{bookId}")
    public String updateBook(@PathVariable Long bookId, Book book, BindingResult result, Model model){
//        For Validation purpose - If the changes was not correct return to the same page refresh
        if(result.hasErrors()){
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String saveBook(Book book, Model model){
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }







}
