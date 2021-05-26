package com.solution.apps.ventas.backend.controllers.categoria;

import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;
import com.solution.shared.infrastructure.spring.ApiController;
import com.solution.ventas.categoria.application.CategoriaResponse;
import com.solution.ventas.categoria.application.find.FindCategoriaQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CategoriaGetController extends ApiController {
    public CategoriaGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/categoria/{id}")
    public HashMap<String, String> index(@PathVariable String id) {
        System.out.println(id);
        CategoriaResponse response = ask(new FindCategoriaQuery(id));
        return new HashMap<>() {
            {
                put("id", response.id());
                put("name", response.nombre());
                put("duration", response.descripcion());
            }
        };
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
