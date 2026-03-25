package com.example.spring_boot.validator;

import com.example.spring_boot.exception.BadRequestException;
import com.example.spring_boot.model.Student;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


public class StudentValidator {
    public void validateStudent(Student student) {
        if(student.getReference() == null || student.getReference().isBlank()) {
            throw new BadRequestException("Student reference is required");
        } else if (student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new BadRequestException("First name is required");
        } else if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new BadRequestException("Last name is required");
        } else if (student.getAge() == null || student.getAge() <= 0) {
            throw new BadRequestException("Age is required");
        }
    }

    public void validateStudentList(List<Student> students) {
        for(Student student : students) {
            validateStudent(student);
        }
    }
}
