package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length=10, nullable = false)
    @NotEmpty(message="First name is required.")
    private String firstName;



    @Column(length=20, nullable = false)
    @NotEmpty(message="Last name is required.")
    private String lastName;

    @NotEmpty(message="Email is required.")
    @Email
    @Column(unique=true, nullable = false, length = 32)
    private String email;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(length=10, nullable = false)
    private String password;


    private String role = "USER";
    private Boolean enabled = false;
}
