package com.ats.courselibrary.controller;


import com.ats.courselibrary.entity.Category;
import com.ats.courselibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class categoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model){
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category) {
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/remove-category/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId, Model model) {
        categoryService.deleteCategory(categoryId);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("update-category/{categoryId}")
    public String updateCategory(@PathVariable Long categoryId, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(categoryId));
        return "update-category";
    }

    @PostMapping("/update-category/{categoryId}")
    public String saveCategory(@PathVariable Long categoryId, Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "redirect:/categories";
    }
}
