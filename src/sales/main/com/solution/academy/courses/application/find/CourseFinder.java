package com.solution.academy.courses.application.find;


import com.solution.academy.courses.application.CourseResponse;
import com.solution.academy.courses.domain.CourseId;
import com.solution.academy.courses.domain.CourseNotExist;
import com.solution.academy.courses.domain.CourseRepository;
import com.solution.shared.domain.Service;

@Service
public final class CourseFinder {
    private final CourseRepository repository;

    public CourseFinder(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseResponse find(String id) throws CourseNotExist {
        return repository.search(id)
                         .map(CourseResponse::fromAggregate)
                         .orElseThrow(() -> new CourseNotExist(id));
    }
}
