package com.backend.expensetrackerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.expensetrackerapi.domain.Category;
import com.backend.expensetrackerapi.services.category.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService _service;

    public CategoryController(CategoryService service) {
        _service = service;
    }

    @GetMapping("/all")
    public List<Category> GetAllCategories() {
        return _service.findAllCategories();
    }

}