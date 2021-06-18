package com.solution.academy.courses.application;


import com.solution.academy.courses.domain.Course;
import com.solution.shared.domain.bus.query.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CourseResponse implements Response {
    private String id;
    private String name;
    private String duration;
    private String categoryId;


    public static CourseResponse fromAggregate(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .duration(course.getDuration())
                .categoryId(course.getCategoryId())
                .build();


    }


}
