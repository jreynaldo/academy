package com.solution.sales.categoria.domain;

public final class CategoryBuilder {
    private CategoryId id;
    private CategoryName nombre;
    private CategoryDescription descripcion;

    private CategoryBuilder() {
    }

    public static CategoryBuilder crear() {
        return new CategoryBuilder();
    }

    public CategoryBuilder id(CategoryId id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder nombre(CategoryName nombre) {
        this.nombre = nombre;
        return this;
    }

    public CategoryBuilder descripcion(CategoryDescription descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Category build() {
        return new Category(id, nombre, descripcion);
    }
}
