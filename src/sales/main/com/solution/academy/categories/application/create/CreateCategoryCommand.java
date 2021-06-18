package com.solution.academy.categories.application.create;

import com.solution.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public final class CreateCategoryCommand implements Command {

    private String id;
    private String name;
    private String descripcion;


}
