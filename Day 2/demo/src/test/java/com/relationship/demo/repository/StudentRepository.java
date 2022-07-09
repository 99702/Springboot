package com.relationship.demo.repository;

import com.relationship.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public class StudentRepository extends JpaRepository<Student, Long> {
}
