package com.example.spring_boot.controller;

import com.example.spring_boot.model.Student;
import com.example.spring_boot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public List<String> addStudents(@RequestBody List<Student> students) {
        studentService.addStudents(students);
        return studentService.getLastNames();
    }
}
