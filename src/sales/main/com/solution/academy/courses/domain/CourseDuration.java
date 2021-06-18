package com.solution.academy.courses.domain;

import com.solution.shared.domain.StringValueObject;

public final class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }

    private CourseDuration() {
        super("");
    }
}
