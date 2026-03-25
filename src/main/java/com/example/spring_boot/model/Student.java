package com.example.spring_boot.model;

import lombok.Data;

@Data

public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;

    public Student(String reference) {
        this.reference = reference;
    }
}
