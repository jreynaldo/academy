package com.solution.ventas.categoria.application.find;

import com.solution.shared.domain.bus.query.Query;

public final class FindCategoriaQuery implements Query {
    private final String id;
    public FindCategoriaQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
