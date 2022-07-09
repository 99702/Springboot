package com.example.qu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name="dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name="profile_pic")
    private String profilePic;

    @Column(name="enabled")
    private Boolean enabled = false;

    @Column(name="role")
    private String role = "USER";

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Post> post = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_COMMENT", referencedColumnName = "id")
    private Set<Comment> comment = new HashSet<>();
}