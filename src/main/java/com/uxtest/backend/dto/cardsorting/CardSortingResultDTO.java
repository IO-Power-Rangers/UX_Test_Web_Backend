package com.uxtest.backend.dto.cardsorting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.UserDTO;
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
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardSortingResultDTO {
    private Long id;
    @JsonProperty
    private CardSortingTestDTO test;
    @JsonProperty
    private UserDTO user;
    @JsonProperty
    private List<CategoryWithSubjectsDTO> categoriesWithSubjects;

    public CardSortingResult parseResult() {
        return CardSortingResult.builder()
                .id(this.getId())
                .test(this.getTest().parseTest())
                .user(this.getUser().parseUser())
                .categoriesWithSubjects(this.getCategoriesWithSubjects()
                        .stream()
                        .map(CategoryWithSubjectsDTO::parseCategoryWithSubjects)
                        .collect(Collectors.toList()))
                .build();
    }
}
