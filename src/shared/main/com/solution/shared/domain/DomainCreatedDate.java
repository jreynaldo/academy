package com.solution.shared.domain;

import java.time.Instant;

public final class DomainCreatedDate extends InstantValueObjet{
    public DomainCreatedDate() {
        super(null);
    }

    public DomainCreatedDate(Instant value) {
        super(value);
    }
}
