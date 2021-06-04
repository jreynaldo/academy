package com.solution.apps.sales.backend.controllers.product;

import com.solution.sales.categories.application.CategoryResponse;
import com.solution.sales.categories.application.find.FindCategoryQuery;
import com.solution.sales.product.application.ProductResponse;
import com.solution.sales.product.application.find.FindProductQuery;
import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;
import com.solution.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class ProductGetController extends ApiController {
    public ProductGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/product/{id}")
    public HashMap<String, String> index(@PathVariable String id) {

        ProductResponse response = ask(new FindProductQuery(id));
        return new HashMap<>() {
            {
                put("id", response.id());
                put("codigo", response.codigo());
                put("nombre", response.nombre());
                put("descripcion", response.descripcion());
                put("imagen", response.imagen());
                put("categoriaId", response.categoriaId());
                put("presentacionId", response.presentacionId());
            }
        };
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
