package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.repository.cardsorting.CategoryWithSubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryWithSubjectsService {
    @Autowired
    CategoryWithSubjectsRepository categoryRepository;

    public CategoryWithSubjects getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public void createCategory(CategoryWithSubjects category) {
        categoryRepository.save(category);
    }

    public void updateCategory(CategoryWithSubjects category, Long id) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            categoryRepository.save(category);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    public List<CategoryWithSubjects> getCategories() {
        return categoryRepository.findAll();
    }
}
