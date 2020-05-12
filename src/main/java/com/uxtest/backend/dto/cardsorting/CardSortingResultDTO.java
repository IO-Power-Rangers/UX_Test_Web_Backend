package com.uxtest.backend.dto.cardsorting;

import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.user.User;
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
public class CardSortingResultDTO {
    private Long id;
    @NotNull
    private CardSortingTest test;
    @NotNull
    private User user;
    private List<CategoryWithSubjects> categoriesWithSubjects;

    public CardSortingResult parseResult() {
        return CardSortingResult.builder()
                .id(this.getId())
                .test(this.getTest())
                .user(this.getUser())
                .categoriesWithSubjects(this.getCategoriesWithSubjects())
                .build();
    }
}
