package com.solution.academy.students.application.search_all;

import com.solution.academy.students.application.StudentResponse;
import com.solution.academy.students.application.StudentsResponse;
import com.solution.academy.students.domain.IStudentRepository;
import com.solution.shared.domain.Service;


import java.util.stream.Collectors;

@Service
public final class AllStudentsSearcher {
    private final IStudentRepository repository;

    public AllStudentsSearcher(IStudentRepository repository) {
        this.repository = repository;
    }

    public StudentsResponse search() {
        return new StudentsResponse(
            repository.searchAll().stream().map(StudentResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
