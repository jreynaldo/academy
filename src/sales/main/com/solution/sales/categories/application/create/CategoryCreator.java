package com.solution.sales.categories.application.create;

import com.solution.shared.domain.DomainCreatedBy;
import com.solution.shared.domain.Identifier;
import com.solution.shared.domain.Service;
import com.solution.sales.categories.domain.*;
import org.springframework.context.ApplicationContext;

@Service
public final class CategoryCreator {
    private final ApplicationContext context;
    private final ICategoryRepository repository;

    public CategoryCreator(ApplicationContext context, ICategoryRepository repository) {
        this.context = context;
        this.repository = repository;
    }


    public void crear(CategoryId id, CategoryName name   , CategoryDescription description) {
        DomainCreatedBy createdBy = new DomainCreatedBy("4567878");
        Category category = Category.create(id)
                .name(name)
                .description(description)
                .createdBy(createdBy)
                .build();
        repository.find(id).map(Category::id).ifPresent(x -> {
            throw  new CategoryExist(x);
        });
        repository.save(category);

    }
}
