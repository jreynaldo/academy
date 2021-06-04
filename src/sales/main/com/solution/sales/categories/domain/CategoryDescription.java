package com.solution.sales.categories.domain;

import com.solution.shared.domain.StringValueObject;

public final class CategoryDescription extends StringValueObject {
    public CategoryDescription(String value) {
        super(value);
    }

    public CategoryDescription() {
        super("");
    }
}
