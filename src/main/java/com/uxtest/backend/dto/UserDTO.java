package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @Email
    private String email;

    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String role;

    private Boolean recordingAgreement;

    private List<CardSortingResult> results;

    public User parseUser() {
        return User.builder()
                .id(this.getId())
                .email(this.getEmail())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .password(this.getPassword())
                .recordingAgreement(this.getRecordingAgreement())
                .role(User.Role.valueOf(this.getRole()))
                .results(this.getResults())
                .build();

    }


}