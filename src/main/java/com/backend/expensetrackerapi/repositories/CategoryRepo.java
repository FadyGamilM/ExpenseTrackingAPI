package com.backend.expensetrackerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.expensetrackerapi.domain.Category;

import jakarta.transaction.Transactional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM et_categories", nativeQuery = true)
    List<Category> findAllCategories();

    @Query(value = "FIND * FROM et_categories AS C WHERE C.id = ?1", nativeQuery = true)
    Category findCategoryById(Long id);

    // // modify category given the category Id
    // @Modifying
    // @Transactional
    // @Query(nativeQuery = true, value = "UPDATE et_categories SET title = ?1 WHERE
    // id = ?2")
    // int updateCategoryTitleById(String newTitle, Long categoryId);

    // @Query(value = "UPDATE et_categories SET description = ?1 WHERE id = ?2")
    // @Modifying
    // @Transactional
    // int updateCategoryDescriptionById(String updatedDesc, Long categoryId);
}