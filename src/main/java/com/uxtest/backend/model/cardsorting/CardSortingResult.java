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
    @JsonIgnoreProperties("results")
    private CardSortingTest test;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnoreProperties("results")
    private User user;

    @NotNull
    @OneToMany(mappedBy = "result")
    @JsonIgnoreProperties("result")
    private List<CategoryWithSubjects> categoriesWithSubjects;

    public CardSortingResultDTO mapToDTO() {
        return CardSortingResultDTO.builder()
                .id(this.getId())
                .test(this.getTest())
                .user(this.getUser())
                .categoriesWithSubjects(this.getCategoriesWithSubjects())
                .build();
    }
}
