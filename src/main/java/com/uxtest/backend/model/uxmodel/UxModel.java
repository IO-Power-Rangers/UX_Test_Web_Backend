package com.uxtest.backend.model.uxmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.UxModelDTO;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
@Table(name = "UxModel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UxModel {
    @Id
    URL axLink;

    @OneToMany(mappedBy = "uxModel")
    private List<Test> tests;

    public UxModelDTO mapToDTO() {
        return UxModelDTO.builder()
                .axLink(this.getAxLink())
                .build();
    }
}
