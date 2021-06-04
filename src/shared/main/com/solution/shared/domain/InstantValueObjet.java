package com.solution.shared.domain;

import java.time.Instant;

public abstract class InstantValueObjet {
    private Instant value;


    public InstantValueObjet(Instant value) {
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "InstantValueObjet{" +
                "value=" + value +
                '}';
    }
}
