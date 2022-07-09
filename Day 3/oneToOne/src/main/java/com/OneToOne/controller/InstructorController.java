package com.OneToOne.controller;

import com.OneToOne.entity.Instructor;
import com.OneToOne.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public List<Instructor> getInstructors(){
        return instructorService.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable(value="id") Long instructorId) throws Exception {
        return instructorService.findById(instructorId);
    }

    @PostMapping("/instructors")
    public Instructor createUser(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

}
