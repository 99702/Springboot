package com.example.qu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@IdClass(Comment.class)
@Data
public class Comment implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Long id;

    @Column(name="comment")
    private String comment;

    @Id
    @ManyToOne()
    @JoinColumn(name = "FK_POST", referencedColumnName = "id", nullable = false)
    private Post post;

    @Id
    @ManyToOne()
    @JoinColumn(name = "FK_USER", nullable = false, referencedColumnName = "id")
    private User user;
}
