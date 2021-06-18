package com.solution.academy.courses.application.search_last;




import com.solution.academy.courses.application.CourseResponse;
import com.solution.academy.courses.application.CoursesResponse;
import com.solution.academy.courses.domain.CourseRepository;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.domain.criteria.Filters;
import com.solution.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class LastCoursesSearcher {
    private final CourseRepository repository;

    public LastCoursesSearcher(CourseRepository repository) {
        this.repository = repository;
    }

    public CoursesResponse search(int courses) {
        Criteria criteria = new Criteria(
            Filters.none(),
                Order.none(),
            Optional.of(courses),
            Optional.empty()
        );

        return new CoursesResponse(
            repository.matching(criteria).stream().map(CourseResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
