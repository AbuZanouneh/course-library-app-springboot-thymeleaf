package com.ats.courselibrary.controller;

import com.ats.courselibrary.entity.Author;
import com.ats.courselibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model){
        List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author){
        return "add-author";
    }

    @GetMapping("/remove-author/{authorId}")
    public String deleteAuthor(@PathVariable Long authorId, Model model){
        authorService.removeAuthor(authorId);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

   @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-author";
        }
       authorService.createAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
       return "redirect:/authors";
   }

    @GetMapping("update-author/{authorId}")
    public String updateAuthor(@PathVariable Long authorId, Model model){
        model.addAttribute("author",authorService.findAuthorById(authorId));
        return "update-author";
    }

    @PostMapping("/update-author/{authorId}")
    public String saveUpdateAuthor(@PathVariable Long authorId,Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }



}
