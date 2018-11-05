package com.ifezue.whoyouepp.controller;


import com.ifezue.whoyouepp.model.Student;
import com.ifezue.whoyouepp.service.contract.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> get() {
        return studentService.getAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }
}
