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
    @JsonIgnoreProperties("categories")
    private CardSortingTest test;

    public CategoryDTO mapToDTO() {
        return CategoryDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .test(this.getTest())
                .build();
    }
}
