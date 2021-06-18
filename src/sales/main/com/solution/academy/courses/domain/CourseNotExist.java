package com.solution.academy.courses.domain;


import com.solution.shared.domain.DomainError;

public final class CourseNotExist extends DomainError {
    public CourseNotExist(String id) {
        super("course_not_exist", String.format("The course <%s> doesn't exist", id));
    }
}
