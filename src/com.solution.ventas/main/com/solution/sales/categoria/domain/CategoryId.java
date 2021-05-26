package com.solution.sales.categoria.domain;

import com.solution.shared.domain.Identifier;

public final class CategoryId extends Identifier {
    public CategoryId(String value) {
        super(value);
    }

    public CategoryId() {
        super("");
    }
}
