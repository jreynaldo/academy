package com.solution.sales.product.application.create;

import com.solution.shared.domain.bus.command.Command;

public final class CreateProductCommand implements Command {

    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoriaId;
    private String presentacionId;
    private String createdBy;

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

    public static Builder create(String id) {
        return new Builder(id);
    }

    public String createdBy() {
               return createdBy;
    }


    public static final class Builder {
        private String id;
        private String codigo;
        private String nombre;
        private String descripcion;
        private String imagen;
        private String categoriaId;
        private String presentacionId;
        private String createdBy;

        private Builder(String id) {
            this.id = id;
        }



        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder imagen(String imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder categoriaId(String categoriaId) {
            this.categoriaId = categoriaId;
            return this;
        }

        public Builder presentacionId(String presentacionId) {
            this.presentacionId = presentacionId;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CreateProductCommand build() {
            CreateProductCommand createProductCommand = new CreateProductCommand();
            createProductCommand.codigo = this.codigo;
            createProductCommand.categoriaId = this.categoriaId;
            createProductCommand.presentacionId = this.presentacionId;
            createProductCommand.nombre = this.nombre;
            createProductCommand.descripcion = this.descripcion;
            createProductCommand.id = this.id;
            createProductCommand.imagen = this.imagen;
            createProductCommand.createdBy = this.createdBy;

            return createProductCommand;
        }
    }
}
