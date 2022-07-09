package com.OneToOne.service;

import com.OneToOne.entity.Instructor;
import com.OneToOne.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public ResponseEntity<Instructor> findById(Long instructorId) throws Exception {
        Instructor user =  instructorRepository.findById(instructorId)
                .orElseThrow(() -> new Exception("Instructor not found :: " + instructorId));
        final Instructor updatedUser = instructorRepository.save(user);
        return ResponseEntity.ok(updatedUser);

    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
/*

 */