package com.solution.academy.categories.application.find;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;
import com.solution.academy.categories.application.CategoryResponse;

@Service
public final class FindCategoryQueryHandler implements QueryHandler<FindCategoryQuery, CategoryResponse> {
 private final FinderCategoryService service;

    public FindCategoryQueryHandler(FinderCategoryService service) {
        this.service = service;
    }

    @Override
    public CategoryResponse handle(FindCategoryQuery query) {
        return service.find(query.id());
    }
}
