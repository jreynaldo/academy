package com.solution.sales.categories.application.find;

import com.solution.shared.domain.bus.query.Query;

public final class FindCategoryQuery implements Query {
    private final String id;
    public FindCategoryQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
