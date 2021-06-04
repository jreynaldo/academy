package com.solution.sales.categories.domain;

import com.solution.shared.domain.StringValueObject;

public final class CategoryName extends StringValueObject {
    public CategoryName(String value) {
        super(value);
    }

    public CategoryName() {
        super("");
    }
}
