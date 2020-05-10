package com.uxtest.backend.dto.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardSortingTestDTO {
    private Long id;
    private List<Category> categories;
    private List<Subject> subjects;

    public CardSortingTest parseTest() {
        return CardSortingTest.builder()
                .id(this.getId())
                .categories(this.getCategories())
                .subjects(this.getSubjects())
                .build();
    }
}
