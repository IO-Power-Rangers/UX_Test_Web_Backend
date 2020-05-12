package com.uxtest.backend.dto.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private CardSortingTest test;

    private List<CategoryWithSubjects> categoriesWithSubjects;

    public Category parseCategory() {
        return Category.builder()
                .id(this.getId())
                .name(this.getName())
                .test(this.getTest())
                .categoriesWithSubjects(this.getCategoriesWithSubjects())
                .build();
    }
}
