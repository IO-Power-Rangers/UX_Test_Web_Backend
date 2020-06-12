package com.uxtest.backend.model.grouping;

import com.uxtest.backend.dto.TestGroupDTO;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TestGroup")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestGroup {
    @Id
    private Long id;

    @NotNull
    private String name;

    @OneToOne
    @MapsId
    private Test test;

    public TestGroupDTO mapToDTO() {
        return TestGroupDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
