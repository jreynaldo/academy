package com.solution.ventas.categoria.domain;

public final class CategoriaBuilder {
    private CategoriaId id;
    private CategoriaNombre nombre;
    private CategoriaDescripcion descripcion;

    private CategoriaBuilder() {
    }

    public static CategoriaBuilder crear() {
        return new CategoriaBuilder();
    }

    public CategoriaBuilder id(CategoriaId id) {
        this.id = id;
        return this;
    }

    public CategoriaBuilder nombre(CategoriaNombre nombre) {
        this.nombre = nombre;
        return this;
    }

    public CategoriaBuilder descripcion(CategoriaDescripcion descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Categoria build() {
        return new Categoria(id, nombre, descripcion);
    }
}
