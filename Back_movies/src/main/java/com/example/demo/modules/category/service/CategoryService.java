package com.example.demo.modules.category.service;

import com.example.demo.modules.category.model.Category;
import com.example.demo.modules.category.model.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository IcategoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.IcategoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<Category> findAll(Pageable pageable) {
        return this.IcategoryRepository.findAll(pageable);
    }

    @Transactional(rollbackFor = { SQLException.class, Exception.class })
    public Category save(Category category) {
        return this.IcategoryRepository.saveAndFlush(category);
    }


}
