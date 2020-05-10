package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.CardSortingTestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JsonIgnoreProperties("test")
    private List<Category> categories;

    @OneToMany(mappedBy = "test")
    @JsonIgnoreProperties("test")
    private List<Subject> subjects;

    public CardSortingTestDTO mapToDTO() {
        return CardSortingTestDTO.builder()
                .id(this.getId())
                .categories(this.getCategories())
                .subjects(this.getSubjects())
                .build();
    }
}
