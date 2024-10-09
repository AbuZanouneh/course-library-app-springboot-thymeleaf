package com.ats.courselibrary;

import com.ats.courselibrary.entity.Author;
import com.ats.courselibrary.entity.Book;
import com.ats.courselibrary.entity.Category;
import com.ats.courselibrary.entity.Publisher;
import com.ats.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourselibraryApplication.class, args);
    }

    // This method will be executed when you lunch the application for the first time.
//    @Bean
//    public CommandLineRunner initialCreate(BookService bookService){
//        return args -> {
//
//            Book book1 = new Book("ABC", "Book name","my first book!");
//            Author author1 = new Author("name1","Test description");
//            Category category1 = new Category("IT books");
//            Publisher publisher1= new Publisher("first publisher");
//            book1.addAuthor(author1);
//            book1.addCategory(category1);
//            book1.addPublisher(publisher1);
//            bookService.createBook(book1);
//
//
//            Book book2 = new Book("ABC_2", "Book name","my second book!");
//            Author author2 = new Author("name2","Test description 2");
//            Category category2 = new Category("Business books");
//            Publisher publisher2= new Publisher("second publisher");
//            book2.addAuthor(author2);
//            book2.addCategory(category2);
//            book2.addPublisher(publisher2);
//            bookService.createBook(book2);
//
//            Book book3 = new Book("ABC_3", "Book name","my third book!");
//            Author author3 = new Author("name3","Test description 3");
//            Category category3 = new Category("Logic books");
//            Publisher publisher3= new Publisher("third publisher");
//            book3.addAuthor(author3);
//            book3.addCategory(category3);
//            book3.addPublisher(publisher3);
//            bookService.createBook(book3);
//
//
//            Book book1 = new Book("ABC_4", "Book name","my forth book!");
//            Author author1 = new Author("name4","Test description 4");
//            Author author2 = new Author("name5","Test description 5");
//            Category category1 = new Category("Sports books");
//            Category category2 = new Category("Collections books");
//            Publisher publisher1= new Publisher("forth publisher");
//            Publisher publisher2= new Publisher("fifth publisher");
//
//            book1.addAuthor(author1);
//            book1.addAuthor(author2);
//            book1.addCategory(category1);
//            book1.addCategory(category2);
//            book1.addPublisher(publisher1);
//            book1.addPublisher(publisher2);
//            bookService.createBook(book1);
//
//        };
//    }

}
