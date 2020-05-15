package com.uxtest.backend.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.UserDTO;
import com.uxtest.backend.model.cardsorting.CardSortingResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String email;

    private String password;

    private Date lastPasswordModified;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean recordingAgreement;

    public enum Role {
        UXER,
        TESTER
    }

    public UserDTO mapToDTO() {
        return UserDTO.builder()
                .id(this.getId())
                .email(this.getEmail())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .recordingAgreement(this.getRecordingAgreement())
                .role(this.getRole().toString())
                .build();
    }

}
