package com.solution.sales.categoria.domain;

import com.solution.shared.domain.StringValueObject;

public final class CategoryName extends StringValueObject {
    public CategoryName(String value) {
        super(value);
    }

    public CategoryName() {
        super("");
    }
}
