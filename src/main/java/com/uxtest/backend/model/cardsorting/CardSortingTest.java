package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="CardSortingTest")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardSortingTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "test")
    private List<Category> categories;

    @OneToMany(mappedBy = "test")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "test")
    private List<CardSortingResult> results;

    public CardSortingTestDTO mapToDTO() {
        return CardSortingTestDTO.builder()
                .id(this.getId())
                .categories(this.getCategories()
                    .stream()
                    .map(Category::mapToDTO)
                    .collect(Collectors.toList()))
                .subjects(this.getSubjects()
                    .stream()
                    .map(Subject::mapToDTO)
                    .collect(Collectors.toList()))
                .results(this.getResults()
                    .stream()
                    .map(CardSortingResult::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }
}
