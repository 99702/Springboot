package com.relationship.demo.repository;

import com.relationship.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public class TeacherRepository extends JpaRepository<Teacher, Long> {
}
