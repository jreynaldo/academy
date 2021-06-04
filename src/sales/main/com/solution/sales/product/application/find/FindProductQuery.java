package com.solution.sales.product.application.find;

import com.solution.shared.domain.bus.query.Query;

public final class FindProductQuery implements Query {
    private final String id;
    public FindProductQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
