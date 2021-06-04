package com.solution.sales.product.application;

import com.solution.sales.product.domain.Product;
import com.solution.shared.domain.bus.query.Response;

public final class ProductResponse implements Response {

    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoriaId;
    private String presentacionId;

    public String id() {
        return id;
    }

    public String codigo() {
        return codigo;
    }

    public String nombre() {
        return nombre;
    }

    public String descripcion() {
        return descripcion;
    }

    public String imagen() {
        return imagen;
    }

    public String categoriaId() {
        return categoriaId;
    }

    public String presentacionId() {
        return presentacionId;
    }


    public static  ProductResponse fromAggregate(Product product){
        return create()
                .id(product.id().value())
                .codigo(product.codigo().value())
                .nombre(product.nombre().value())
                .descripcion(product.descripcion().value())
                .imagen(product.imagen().value())
                .categoriaId(product.categoriaId().value())
                .presentacionId(product.presentacionId().value())
                .build();


    }
    public static Build create() {
        return new Build();
    }



    public static final class Build {
        private String id;
        private String codigo;
        private String nombre;
        private String descripcion;
        private String imagen;
        private String categoriaId;
        private String presentacionId;

        private Build() {
        }


        public Build id(String id) {
            this.id = id;
            return this;
        }

        public Build codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Build nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Build descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Build imagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public Build categoriaId(String categoriaId) {
            this.categoriaId = categoriaId;
            return this;
        }

        public Build presentacionId(String presentacionId) {
            this.presentacionId = presentacionId;
            return this;
        }

        public ProductResponse build() {
            ProductResponse productResponse = new ProductResponse();
            productResponse.descripcion = this.descripcion;
            productResponse.imagen = this.imagen;
            productResponse.categoriaId = this.categoriaId;
            productResponse.presentacionId = this.presentacionId;
            productResponse.nombre = this.nombre;
            productResponse.codigo = this.codigo;
            productResponse.id = this.id;
            return productResponse;
        }
    }
}
