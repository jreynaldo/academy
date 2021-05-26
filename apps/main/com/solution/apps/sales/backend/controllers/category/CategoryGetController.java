package com.solution.apps.sales.backend.controllers.category;

import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;
import com.solution.shared.infrastructure.spring.ApiController;
import com.solution.sales.categoria.application.CategoryResponse;
import com.solution.sales.categoria.application.find.FindCategoryQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CategoryGetController extends ApiController {
    public CategoryGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/categoria/{id}")
    public HashMap<String, String> index(@PathVariable String id) {
        System.out.println(id);
        CategoryResponse response = ask(new FindCategoryQuery(id));
        return new HashMap<>() {
            {
                put("id", response.id());
                put("name", response.name());
                put("description", response.description());
            }
        };
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
