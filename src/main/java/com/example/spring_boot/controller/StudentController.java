package com.example.spring_boot.controller;

import com.example.spring_boot.model.Student;
import com.example.spring_boot.service.StudentService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public String addStudent(@RequestBody List<Student> students) {
        studentService.addStudents(students);
        return studentService.getStoredLastName();
    }

    @GetMapping
    public String getStudents(@RequestHeader("Accept") String acceptHeader) {
        if (acceptHeader.equals("text/plain")) {
            return studentService.getStoredLastName();
        }
        return "Not supported format";
    }
}
