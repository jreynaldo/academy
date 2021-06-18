package com.solution.academy.courses.domain;


import com.solution.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    void save(Course course);

    Optional<Course> search(String id);

    List<Course> matching(Criteria criteria);
}
