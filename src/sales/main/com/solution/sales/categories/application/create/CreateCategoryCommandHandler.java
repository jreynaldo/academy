package com.solution.sales.categories.application.create;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;
import com.solution.sales.categories.domain.CategoryDescription;
import com.solution.sales.categories.domain.CategoryId;
import com.solution.sales.categories.domain.CategoryName;

@Service
public final class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand> {
    private final CategoryCreator service;

    public CreateCategoryCommandHandler(CategoryCreator service) {
        this.service = service;
    }

    @Override
    public void handle(CreateCategoryCommand command) {
        service.crear( new CategoryId(command.id()), new CategoryName(command.nombre()), new CategoryDescription(command.descripcion()));
    }
}
