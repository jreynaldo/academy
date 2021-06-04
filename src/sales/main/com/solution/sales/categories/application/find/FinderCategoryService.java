package com.solution.sales.categories.application.find;

import com.solution.shared.domain.Service;
import com.solution.sales.categories.application.CategoryResponse;
import com.solution.sales.categories.domain.CategoryId;
import com.solution.sales.categories.domain.ICategoryRepository;

@Service
public final class FinderCategoryService {
    private final ICategoryRepository repository;

    public FinderCategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponse find(CategoryId id){
        return CategoryResponse.fromAggregate(repository.find(id).orElse(null));
    }
}
