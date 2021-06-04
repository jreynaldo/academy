package com.solution.sales.product.domain;

import com.solution.shared.domain.AggregateRoot;
import com.solution.shared.domain.DomainCreatedBy;

import java.io.Serializable;
import java.util.HashMap;

public class Product extends AggregateRoot {
    private ProductId id;
    private ProductCodigo codigo;
    private ProductNombre nombre;
    private ProductDescripcion descripcion;
    private ProductImagen imagen;
    private ProductCategoriaId categoriaId;
    private ProductPresentacionId presentacionId;


    public Product() {
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }






    public ProductId id() {
        return id;
    }

    public ProductCodigo codigo() {
        return codigo;
    }

    public ProductNombre nombre() {
        return nombre;
    }

    public ProductDescripcion descripcion() {
        return descripcion;
    }

    public ProductImagen imagen() {
        return imagen;
    }

    public ProductCategoriaId categoriaId() {
        return categoriaId;
    }

    public ProductPresentacionId presentacionId() {
        return presentacionId;
    }


    public static Builder create() {
        return new Builder();
    }


    public static final class Builder {
        private ProductId id;
        private ProductCodigo codigo;
        private ProductNombre nombre;
        private ProductDescripcion descripcion;
        private ProductImagen imagen;
        private ProductCategoriaId categoriaId;
        private ProductPresentacionId presentacionId;
        private DomainCreatedBy createdBy;

        private Builder() {
        }


        public Builder id(ProductId id) {
            this.id = id;
            return this;
        }

        public Builder codigo(ProductCodigo codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(ProductNombre nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(ProductDescripcion descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder imagen(ProductImagen imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder categoriaId(ProductCategoriaId categoriaId) {
            this.categoriaId = categoriaId;
            return this;
        }

        public Builder presentacionId(ProductPresentacionId presentacionId) {
            this.presentacionId = presentacionId;
            return this;
        }

        public Builder createdBy(DomainCreatedBy createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.imagen = this.imagen;
            product.descripcion = this.descripcion;
            product.nombre = this.nombre;
            product.id = this.id;
            product.codigo = this.codigo;
            product.categoriaId = this.categoriaId;
            product.presentacionId = this.presentacionId;
            product.createdBy = this.createdBy;
            return product;
        }
    }
}
