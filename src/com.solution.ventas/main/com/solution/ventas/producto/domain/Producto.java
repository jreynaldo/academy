package com.solution.ventas.producto.domain;

public class Producto {
    private ProductoId id;
    private ProductoCodigo codigo;
    private ProductoNombre nombre;
    private ProductoDescripcion descripcion;
    private ProductoImagen imagen;
    private ProductoCategoriaId categoriaId;
    private ProductoPresentacion presentacionId;



    public ProductoId id() {
        return id;
    }

    public ProductoCodigo codigo() {
        return codigo;
    }

    public ProductoNombre nombre() {
        return nombre;
    }

    public ProductoDescripcion descripcion() {
        return descripcion;
    }

    public ProductoImagen imagen() {
        return imagen;
    }

    public ProductoCategoriaId categoriaId() {
        return categoriaId;
    }

    public ProductoPresentacion presentacionId() {
        return presentacionId;
    }

    public static final class ProductoBuilder {
        private ProductoId id;
        private ProductoCodigo codigo;
        private ProductoNombre nombre;
        private ProductoDescripcion descripcion;
        private ProductoImagen imagen;
        private ProductoCategoriaId categoriaId;
        private ProductoPresentacion presentacionId;

        private ProductoBuilder() {
        }

        public static ProductoBuilder  newProducto() {
            return new ProductoBuilder();
        }

        public ProductoBuilder id(ProductoId id) {
            this.id = id;
            return this;
        }

        public ProductoBuilder codigo(ProductoCodigo codigo) {
            this.codigo = codigo;
            return this;
        }

        public ProductoBuilder nombre(ProductoNombre nombre) {
            this.nombre = nombre;
            return this;
        }

        public ProductoBuilder descripcion(ProductoDescripcion descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ProductoBuilder imagen(ProductoImagen imagen) {
            this.imagen = imagen;
            return this;
        }

        public ProductoBuilder categoriaId(ProductoCategoriaId categoriaId) {
            this.categoriaId = categoriaId;
            return this;
        }

        public ProductoBuilder presentacionId(ProductoPresentacion presentacionId) {
            this.presentacionId = presentacionId;
            return this;
        }

        public Producto build() {
            Producto producto = new Producto();
            producto.imagen = this.imagen;
            producto.descripcion = this.descripcion;
            producto.nombre = this.nombre;
            producto.id = this.id;
            producto.codigo = this.codigo;
            producto.categoriaId = this.categoriaId;
            producto.presentacionId = this.presentacionId;
            return producto;
        }
    }
}
