package com.solution.sales.categoria.application.create;

import com.solution.shared.domain.Service;
import com.solution.sales.categoria.domain.*;
import com.solution.sales.categoria.infastructure.ElasticsearchCategoryRepository;

import java.util.List;

@Service
public final class CategoryCreator {

    private final ElasticsearchCategoryRepository repository;

    public CategoryCreator(ElasticsearchCategoryRepository repository) {
        this.repository = repository;
    }


    public void crear(CategoryId id, CategoryName nombre   , CategoryDescription descripcion) {

        Category category = CategoryBuilder.crear()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .build();

        repository.save(category);

        List<Category> categories = repository.searchAll();
        categories.forEach(System.out::println);

    }
}
