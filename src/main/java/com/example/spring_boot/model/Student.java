package com.example.spring_boot.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private String age;
}
