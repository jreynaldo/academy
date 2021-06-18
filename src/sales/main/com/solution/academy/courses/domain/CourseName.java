package com.solution.academy.courses.domain;


import com.solution.shared.domain.StringValueObject;

public final class CourseName extends StringValueObject {
    public CourseName(String value) {
        super(value);
    }

    public CourseName() {
        super("");
    }
}
