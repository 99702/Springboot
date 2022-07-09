package com.relationship.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Data
@Repository
public class Subject {
    // id column
    private Long id;

    // name column
    private String name;


    // teacher column , many teachers can enroll only one column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    // enrolled students , many students enrolled in many courses
    @ManyToMany
    @JoinTable(name="student_enrolled", joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    Set<Student> enrolledStudents = new HashSet<>();

}
