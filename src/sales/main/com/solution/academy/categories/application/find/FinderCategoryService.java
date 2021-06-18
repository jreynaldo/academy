package com.solution.academy.categories.application.find;

import com.solution.shared.domain.Service;
import com.solution.academy.categories.application.CategoryResponse;
import com.solution.academy.categories.domain.ICategoryRepository;

@Service
public final class FinderCategoryService {
    private final ICategoryRepository repository;

    public FinderCategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponse find(String id){
        return CategoryResponse.fromAggregate(repository.find(id).orElse(null));
    }
}
