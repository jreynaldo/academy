package com.solution.ventas.categoria.application;

import com.solution.shared.domain.bus.query.Response;
import com.solution.ventas.categoria.domain.Categoria;

public final class CategoriaResponse implements Response {
    private final String id;
    private final String nombre;
    private final String descripcion;

    public CategoriaResponse(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String descripcion() {
        return descripcion;
    }

    public static CategoriaResponse fromAggregate(Categoria categoria){
        return new CategoriaResponse(categoria.id().value(), categoria.nombre().value(), categoria.descripcion().value());
    }
}
