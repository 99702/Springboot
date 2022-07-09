package com.OneToOne.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class InstructorDetail {
    @Id
    private Long id;

    private String youtubeChannel;
    private String hobby;
}
