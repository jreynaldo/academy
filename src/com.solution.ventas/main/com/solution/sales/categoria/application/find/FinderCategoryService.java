package com.solution.sales.categoria.application.find;

import com.solution.shared.domain.Service;
import com.solution.sales.categoria.application.CategoryResponse;
import com.solution.sales.categoria.domain.CategoryId;
import com.solution.sales.categoria.domain.ICategoryRepository;

@Service
public final class FinderCategoryService {
    private final ICategoryRepository repository;

    public FinderCategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponse find(CategoryId id){
        return CategoryResponse.fromAggregate(repository.find(id).orElseThrow(() ->new RuntimeException("Error")));
    }
}
