package com.example.spring_boot.controller;

import com.example.spring_boot.model.Student;
import com.example.spring_boot.service.StudentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> students) {
        List<Student> storedStudents;
        try {
            storedStudents = studentService.addStudents(students);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(storedStudents);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(@RequestHeader(required = false, defaultValue = "", name = "Accept") String acceptHeader) {
        try {
            if(acceptHeader.equals("text/plain") || acceptHeader.equals("application/json")) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(studentService.getStudentList());
            } else if (acceptHeader.isEmpty()) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
