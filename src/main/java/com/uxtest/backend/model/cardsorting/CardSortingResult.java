package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.CardSortingResultDTO;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="CardSortingResult")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardSortingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cardSortingTest_id")
    private CardSortingTest test;

    @NotNull
    @OneToMany(mappedBy = "result")
    private List<CategoryWithSubjects> categoriesWithSubjects;

    public CardSortingResultDTO mapToDTO() {
        return CardSortingResultDTO.builder()
                .id(this.getId())
                .test(this.getTest().mapToDTO())
                .categoriesWithSubjects(this.getCategoriesWithSubjects()
                    .stream()
                    .map(CategoryWithSubjects::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }
}
