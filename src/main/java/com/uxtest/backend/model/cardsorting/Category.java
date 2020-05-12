package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.dto.cardsorting.CategoryDTO;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "cardSortingTest_id")
    private CardSortingTest test;

    @OneToMany(mappedBy = "category")
    private List<CategoryWithSubjects> categoriesWithSubjects;

    public CategoryDTO mapToDTO() {
        return CategoryDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .test(this.getTest().mapToDTO())
                .categoriesWithSubjects(this.getCategoriesWithSubjects()
                    .stream()
                    .map(CategoryWithSubjects::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }
}
