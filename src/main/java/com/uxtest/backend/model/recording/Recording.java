package com.uxtest.backend.model.recording;


import com.uxtest.backend.dto.recording.RecordingDTO;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recording {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="testId", nullable = false)
    private Test test;

    public byte[] video;

    public RecordingDTO mapToDTO() {
        return RecordingDTO.builder()
                .id(this.getId())
                .user(this.user.mapToDTO())
                .test(this.test.mapToDTO())
                .video(new String(Base64.encode(this.video)))
                .build();
    }
}
