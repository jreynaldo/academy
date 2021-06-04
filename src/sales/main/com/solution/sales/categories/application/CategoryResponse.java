package com.solution.sales.categories.application;

import com.solution.shared.domain.bus.query.Response;
import com.solution.sales.categories.domain.Category;

public final class CategoryResponse implements Response {
    private final String id;
    private final String name;
    private final String description;

    public CategoryResponse(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public static CategoryResponse fromAggregate(Category category){
        return new CategoryResponse(category.id().value(), category.nombre().value(), category.descripcion().value());
    }
}
