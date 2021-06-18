package com.solution.academy.courses.application.find;


import com.solution.academy.courses.application.CourseResponse;
import com.solution.academy.courses.domain.CourseId;
import com.solution.academy.courses.domain.CourseNotExist;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCourseQueryHandler implements QueryHandler<FindCourseQuery, CourseResponse> {
    private final CourseFinder finder;

    public FindCourseQueryHandler(CourseFinder finder) {
        this.finder = finder;
    }

    @Override
    public CourseResponse handle(FindCourseQuery query) throws CourseNotExist {
        return finder.find(query.id());
    }
}
