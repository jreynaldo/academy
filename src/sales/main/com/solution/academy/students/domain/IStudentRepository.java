package com.solution.academy.students.domain;

import com.solution.academy.categories.domain.Category;
import com.solution.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {
    List<Student> searchAll();
    void save(Student student);
   List<Student> matching(Criteria criteria);
    Optional<Student> find(String id);
}
