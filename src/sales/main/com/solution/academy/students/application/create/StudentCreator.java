package com.solution.academy.students.application.create;

import com.solution.academy.students.domain.IStudentRepository;
import com.solution.academy.students.domain.Student;
import com.solution.shared.domain.Service;

@Service
public class StudentCreator {
private final IStudentRepository repository;

    public StudentCreator(IStudentRepository repository) {
        this.repository = repository;
    }

    public void create(String id,String email, String password) {
        Student student = Student.builder().id(id).email(email).password(password).build();
    }
}
