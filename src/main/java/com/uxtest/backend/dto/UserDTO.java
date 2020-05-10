package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;


    @Email
    private String email;

    private String password;


    private String firstName;


    private String lastName;


    private String role;

    private Boolean recordingAgreement;

    public User parseUser() {

        User.Role role = null;

        if (this.getRole() != null) {
            role = User.Role.valueOf(this.getRole());
        }

        return User.builder()
                .id(getId())
                .email(this.getEmail())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .password(this.getPassword())
                .recordingAgreement(this.getRecordingAgreement())
                .role(role)
                .build();

    }


}