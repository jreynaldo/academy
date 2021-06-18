package com.solution.academy.courses.application.create;


import com.solution.academy.courses.domain.*;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.event.EventBus;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus eventBus;

    public CourseCreator(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(String id, String name, String duration, String categoryId) {
        Course course = Course.builder()
                .id(id)
                .name(name)
                .duration(duration)
                .categoryId(categoryId)
                .build();
        repository.save(course);
        eventBus.publish(course.pullDomainEvents());
    }
}
