package com.solution.academy.categories.domain;

import com.solution.shared.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Category extends AggregateRoot {
    private  String id;
    private  String name;
    private  String description;


}