package com.solution.academy.courses.application;


import com.solution.shared.domain.bus.query.Response;

import java.util.List;

public final class CoursesResponse implements Response {
    private final List<CourseResponse> courses;

    public CoursesResponse(List<CourseResponse> courses) {
        this.courses = courses;
    }

    public List<CourseResponse> courses() {
        return courses;
    }
}
