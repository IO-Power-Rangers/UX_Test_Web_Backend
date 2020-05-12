package com.uxtest.backend.dto.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.cardsorting.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithSubjectsDTO {
    private Long id;
    @NotNull
    private CategoryDTO category;
    @NotNull
    private CardSortingResultDTO result;
    private List<SubjectDTO> subjects;

    public CategoryWithSubjects parseCategoryWithSubjects() {
        return CategoryWithSubjects.builder()
                .id(this.getId())
                .category(this.getCategory().parseCategory())
                .result(this.getResult().parseResult())
                .subjects(this.getSubjects()
                    .stream()
                    .map(SubjectDTO::parseSubject)
                    .collect(Collectors.toList()))
                .build();
    }
}
