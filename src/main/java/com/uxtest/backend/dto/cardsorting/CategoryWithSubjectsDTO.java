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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithSubjectsDTO {
    private Long id;
    @NotNull
    private Category category;
    @NotNull
    private CardSortingResult result;
    private List<Subject> subjects;

    public CategoryWithSubjects parseCategoryWithSubjects() {
        return CategoryWithSubjects.builder()
                .id(this.getId())
                .category(this.getCategory())
                .result(this.getResult())
                .subjects(this.getSubjects())
                .build();
    }
}
