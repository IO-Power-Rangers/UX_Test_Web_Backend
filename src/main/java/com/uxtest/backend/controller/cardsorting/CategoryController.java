package com.uxtest.backend.controller.cardsorting;

import com.uxtest.backend.dto.cardsorting.CategoryDTO;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.service.cardsorting.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/api/cardsorting/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    @ResponseBody
    public CategoryDTO getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories().stream().map(Category::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO.parseCategory());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        categoryService.updateCategory(categoryDTO.parseCategory(), id);
    }
}
