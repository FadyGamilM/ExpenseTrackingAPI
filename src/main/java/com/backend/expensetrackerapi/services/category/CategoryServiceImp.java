package com.backend.expensetrackerapi.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.expensetrackerapi.domain.Category;
import com.backend.expensetrackerapi.repositories.CategoryRepo;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepo _repo;

    public CategoryServiceImp(CategoryRepo repo) {
        _repo = repo;
    }

    @Override
    public List<Category> findAllCategories() {
        return _repo.findAllCategories();
    }

    @Override
    public Category findCategoryById(Long id) {
        return _repo.findCategoryById(id);
    }

}