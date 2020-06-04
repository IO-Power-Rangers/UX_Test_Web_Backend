package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import com.uxtest.backend.model.user.User;
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

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User creator;

    @OneToMany(mappedBy = "test")
    private List<Category> categories;

    @OneToMany(mappedBy = "test")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "test")
    private List<CardSortingResult> results;

    public void addResult(CardSortingResult result){
        results.add(result);
    }

    public CardSortingTestDTO mapToDTO() {
        if(creator!=null)
            return CardSortingTestDTO.builder()
                    .id(this.getId())
                    .creator(this.getCreator().mapToDTO())
                    .categories(this.getCategories()
                        .stream()
                        .map(Category::mapToDTO)
                        .collect(Collectors.toList()))
                    .subjects(this.getSubjects()
                        .stream()
                        .map(Subject::mapToDTO)
                        .collect(Collectors.toList()))
                    .build();
        else
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
                    .build();
    }
}
