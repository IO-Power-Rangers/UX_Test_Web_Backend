package com.uxtest.backend.service.cardsorting;

import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.cardsorting.Subject;
import com.uxtest.backend.repository.cardsorting.CategoryRepository;
import com.uxtest.backend.repository.cardsorting.CategoryWithSubjectsRepository;
import com.uxtest.backend.repository.cardsorting.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryWithSubjectsService {
    @Autowired
    CategoryWithSubjectsRepository categoryWithSubjectsRepository;
    @Autowired
    SubjectService subjectService;
    @Autowired
    CategoryService baseCategoryService;

    public CategoryWithSubjects getCategoryById(Long id) {
        return categoryWithSubjectsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public void createCategory(CategoryWithSubjects category) {
        categoryWithSubjectsRepository.save(category);
        updateSubjects(category.getSubjects(), category);
        updateBaseCategory(category.getCategory(), category);
    }

    private void updateSubjects(List<Subject> subjects, CategoryWithSubjects category) {
        subjects.forEach(s -> {
            Subject subject = subjectService.getSubjectById(s.getId());
            subject.addCategory(category);
            subjectService.createSubject(subject);
        });
    }

    private void updateBaseCategory(Category baseCategory, CategoryWithSubjects categoryWithSubjects) {
        Category category = baseCategoryService.getCategoryById(baseCategory.getId());
        category.addCategoryWithSubject(categoryWithSubjects);
        baseCategoryService.createCategory(category);
    }

    public void updateCategory(CategoryWithSubjects category, Long id) {
        if (categoryWithSubjectsRepository.existsById(id)) {
            category.setId(id);
            categoryWithSubjectsRepository.save(category);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    public List<CategoryWithSubjects> getCategories() {
        return categoryWithSubjectsRepository.findAll();
    }
}
