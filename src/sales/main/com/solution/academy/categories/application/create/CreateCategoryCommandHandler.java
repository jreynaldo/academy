package com.solution.academy.categories.application.create;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand> {
    private final CategoryCreator service;

    public CreateCategoryCommandHandler(CategoryCreator service) {
        this.service = service;
    }

    @Override
    public void handle(CreateCategoryCommand command) {
        service.crear(
                command.getId() ,
                command.getName(),
                command.getDescripcion());
    }
}
