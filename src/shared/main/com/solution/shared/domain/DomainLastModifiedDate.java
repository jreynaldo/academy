package com.solution.shared.domain;

import com.solution.shared.domain.InstantValueObjet;

import java.time.Instant;

public final class DomainLastModifiedDate extends InstantValueObjet {
    public DomainLastModifiedDate() {
        super(null);
    }

    public DomainLastModifiedDate(Instant value) {
        super(value);
    }
}
