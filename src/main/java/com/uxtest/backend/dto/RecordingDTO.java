package com.uxtest.backend.dto;


import com.uxtest.backend.model.Recording;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.util.Base64;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RecordingDTO {

    private Long id;

    @NotNull
    private UserDTO user;

    @NotNull
    private TestDTO test;

    @NotNull
    private String video;

    public Recording parseRecording() {
        return Recording.builder()
                .id(this.getId())
                .user(this.user.parseUser())
                .test(this.test.parseTest())
                .video(Base64.decode(this.video))
                .build();
    }

}
