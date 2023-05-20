package com.backend.expensetrackerapi.services.category;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;

import com.backend.expensetrackerapi.domain.Category;

public interface CategoryService {
    List<Category> findAllCategories();

    Category findCategoryById(Long id);

}