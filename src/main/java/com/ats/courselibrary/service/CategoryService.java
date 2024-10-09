package com.ats.courselibrary.service;


import com.ats.courselibrary.entity.Category;
import com.ats.courselibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Layer
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long categoryId){
        Category category;
        category =  categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        return category;
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId){
        Category category;
        category =  categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.deleteById(category.getCategoryId());
    }

}
