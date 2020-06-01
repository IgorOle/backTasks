package ru.igo.tasklist.back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.igo.tasklist.back.entity.Category;
import ru.igo.tasklist.back.repository.CategoryRepository;

@RequestMapping("/category")
@RestController
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(value = "/add")
    public Category add(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
