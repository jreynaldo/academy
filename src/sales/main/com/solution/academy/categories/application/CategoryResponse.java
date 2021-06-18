package com.solution.academy.categories.application;

import com.solution.shared.domain.bus.query.Response;
import com.solution.academy.categories.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class CategoryResponse implements Response {
    private final String id;
    private final String name;
    private final String description;





    public static CategoryResponse fromAggregate(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
