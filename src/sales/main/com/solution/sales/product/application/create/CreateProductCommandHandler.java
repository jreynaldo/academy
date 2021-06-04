package com.solution.sales.product.application.create;

import com.solution.sales.product.domain.*;
import com.solution.shared.domain.DomainCreatedBy;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateProductCommandHandler implements CommandHandler<CreateProductCommand> {
 private final ProductCreator creator;

    public CreateProductCommandHandler(ProductCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateProductCommand command) {
         creator.create(
                 new ProductId(command.id()),
                 new ProductCodigo(command.codigo()),
                 new ProductNombre(command.nombre()),
                 new ProductDescripcion(command.descripcion()),
                 new ProductImagen(command.imagen()),
                 new ProductCategoriaId(command.categoriaId()),
                 new ProductPresentacionId(command.presentacionId()),
                 new DomainCreatedBy(command.createdBy())

         );
    }
}
