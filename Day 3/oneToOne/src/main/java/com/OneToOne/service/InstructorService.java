package com.OneToOne.service;

import com.OneToOne.entity.Instructor;
import com.OneToOne.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    public List<Instructor> findAll();

    ResponseEntity<Instructor> findById(Long instructorId) throws Exception;

    Instructor save(Instructor instructor);
}
