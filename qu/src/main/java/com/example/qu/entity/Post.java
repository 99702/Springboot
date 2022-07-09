package com.example.qu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USER", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name="title", unique = true, nullable = false)
    private String title;
    @Column(name="description", nullable = false)
    private String description;

    private String saman;

}
