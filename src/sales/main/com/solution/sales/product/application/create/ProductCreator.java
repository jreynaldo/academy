package com.solution.sales.product.application.create;

import com.solution.sales.product.domain.*;
import com.solution.shared.domain.DomainCreatedBy;
import com.solution.shared.domain.Service;

@Service
public final class ProductCreator {
    private final IProductRepository repository;

    public ProductCreator(IProductRepository repository) {
        this.repository = repository;
    }

    public void create(ProductId id,
                       ProductCodigo codigo,
                       ProductNombre nombre,
                       ProductDescripcion descripcion,
                       ProductImagen imagen,
                       ProductCategoriaId categoriaId, ProductPresentacionId presentacionId, DomainCreatedBy createdBy) {

        Product product = Product.create()
                .id(id)
                .codigo(codigo)
                .nombre(nombre)
                .descripcion(descripcion)
                .imagen(imagen)
                .categoriaId(categoriaId)
                .presentacionId(presentacionId)
                .createdBy(createdBy)
                .build();
        repository.find(id).map(Product::id).ifPresent(x -> { throw new ProductExist(x);});
        repository.save(product);
    }
}
