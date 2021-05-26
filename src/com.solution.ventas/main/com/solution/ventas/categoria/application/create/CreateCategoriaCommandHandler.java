package com.solution.ventas.categoria.application.create;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;
import com.solution.ventas.categoria.domain.CategoriaDescripcion;
import com.solution.ventas.categoria.domain.CategoriaId;
import com.solution.ventas.categoria.domain.CategoriaNombre;

@Service
public final class CreateCategoriaCommandHandler implements CommandHandler<CreateCategoriaCommand> {
    private final CategoriaCreator service;

    public CreateCategoriaCommandHandler(CategoriaCreator service) {
        this.service = service;
    }

    @Override
    public void handle(CreateCategoriaCommand command) {
        service.crear( new CategoriaId(command.id()), new CategoriaNombre(command.nombre()), new CategoriaDescripcion(command.descripcion()));
    }
}
