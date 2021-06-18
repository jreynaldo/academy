package com.solution.academy.students.application;

import com.solution.academy.students.domain.Student;
import com.solution.shared.domain.bus.query.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
public final class StudentResponse implements Response {
    private String id;
    private String email;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String gender;



    public static StudentResponse fromAggregate(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .email(student.getEmail())
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .birthDate(student.getBirthDate())
                .gender(student.getGender())
                .build();

    }


}
