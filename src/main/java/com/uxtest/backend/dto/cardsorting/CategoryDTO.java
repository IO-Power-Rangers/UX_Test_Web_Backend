package com.uxtest.backend.dto.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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

    public Category parseCategory() {
        return Category.builder()
                .id(this.getId())
                .name(this.getName())
                .test(this.getTest())
                .build();
    }
}
