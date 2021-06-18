package com.solution.academy.courses.domain;



import com.solution.shared.domain.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Course extends AggregateRoot {
    private  String       id;
    private  String     name;
    private  String duration;
    private String categoryId;


}
