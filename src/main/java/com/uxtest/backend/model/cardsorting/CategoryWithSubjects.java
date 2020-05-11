package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import com.uxtest.backend.dto.cardsorting.CategoryWithSubjectsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name="CategoryWithSubjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryWithSubjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("categoriesWithSubjects")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cardSortingResult_id")
    @JsonIgnoreProperties("categoriesWithSubjects")
    private CardSortingResult result;

    @OneToMany(mappedBy = "categoryWithSubjects")
    @JsonIgnoreProperties("categoryWithSubjects")
    private List<Subject> subjects;

    public CategoryWithSubjectsDTO mapToDTO() {
        return CategoryWithSubjectsDTO.builder()
                .id(this.getId())
                .category(this.getCategory())
                .result(this.getResult())
                .subjects(this.getSubjects())
                .build();
    }
}
