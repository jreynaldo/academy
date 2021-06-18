package com.solution.academy.students.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Student {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String gender;
    private Student(String id, String email, String password){
        this.id=id;
        this.email = email;
        this.password = password;
    }
}
