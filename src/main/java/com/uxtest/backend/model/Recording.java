package com.uxtest.backend.model;


import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

//    @ManyToOne
//    @JoinColumn(name="testId", nullable = false)
//    private Test test;

    private byte[] video;

    public Recording(byte[] video){
        this.video = video;
    }

}
