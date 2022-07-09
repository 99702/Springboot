package com.example.annotation.controller;

import com.example.annotation.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class MyController {

    @Autowired
    @Qualifier("getStudent")
    private Student student;

    @RequestMapping(value="/home", method= RequestMethod.GET)
    @ResponseBody // this automatically serialize into json and pass back into http response
    public Student home(@RequestBody Student st){
        System.out.println("This is home method.");
        return this.student;
    }
}
