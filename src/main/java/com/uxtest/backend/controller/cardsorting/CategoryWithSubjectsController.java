package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.CategoryWithSubjectsDTO;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.service.cardsorting.CategoryWithSubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/cardsorting/resultCategories")
@RestController
public class CategoryWithSubjectsController {
    @Autowired
    private CategoryWithSubjectsService categoryService;

    @GetMapping("/{id}")
    @ResponseBody
    public CategoryWithSubjectsDTO getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<CategoryWithSubjectsDTO> getCategories() {
        return categoryService.getCategories().stream().map(CategoryWithSubjects::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryWithSubjectsDTO categoryDTO) {
        categoryService.createCategory(categoryDTO.parseCategoryWithSubjects());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@RequestBody CategoryWithSubjectsDTO categoryDTO, @PathVariable Long id) {
        categoryService.updateCategory(categoryDTO.parseCategoryWithSubjects(), id);
    }
}
