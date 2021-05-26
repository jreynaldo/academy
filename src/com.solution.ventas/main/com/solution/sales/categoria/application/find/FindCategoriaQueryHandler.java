package com.solution.sales.categoria.application.find;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;
import com.solution.sales.categoria.application.CategoryResponse;
import com.solution.sales.categoria.domain.CategoryId;

@Service
public final class FindCategoriaQueryHandler implements QueryHandler<FindCategoryQuery, CategoryResponse> {
 private final FinderCategoryService service;

    public FindCategoriaQueryHandler(FinderCategoryService service) {
        this.service = service;
    }

    @Override
    public CategoryResponse handle(FindCategoryQuery query) {
        return service.find(new CategoryId(query.id()));
    }
}
