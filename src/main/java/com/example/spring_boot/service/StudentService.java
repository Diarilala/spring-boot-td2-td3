package com.example.spring_boot.service;

import com.example.spring_boot.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final List<Student> studentStorage = new ArrayList<>();

    public List<Student> addStudents(List<Student> students) {
        studentStorage.addAll(students);
        return studentStorage;
    }

    public List<String> getStoredLastName() {
        return studentStorage.stream()
                .map(Student::getLastName)
                .toList();
    }

    public List<Student> getStudentList() {
        return studentStorage;
    }

}
