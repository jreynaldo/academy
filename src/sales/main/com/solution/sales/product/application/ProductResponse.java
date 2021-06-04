package com.solution.sales.product.application;

public final class ProductResponse {

    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoriaId;
    private String presentacionId;


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
