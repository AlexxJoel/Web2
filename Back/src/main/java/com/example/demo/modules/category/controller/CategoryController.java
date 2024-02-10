package com.example.demo.modules.category.controller;

import lombok.AllArgsConstructor;
import com.example.demo.modules.category.model.Category;
import com.example.demo.modules.category.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"})
@AllArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping("/")
    public Page<Category> getAll(Pageable pageable) {
        return this.categoryService.findAll(pageable);
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

}
