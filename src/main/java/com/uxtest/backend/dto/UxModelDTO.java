package com.uxtest.backend.dto;

import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.uxmodel.UxModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UxModelDTO {
    private URL axLink;

    private List<Test> tests;

    public UxModel parseUxModel() {
        return UxModel.builder()
                .axLink(this.getAxLink())
                .tests(this.getTests())
                .build();
    }
}
