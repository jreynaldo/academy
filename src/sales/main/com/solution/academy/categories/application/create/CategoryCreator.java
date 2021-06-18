package com.solution.academy.categories.application.create;

import com.solution.academy.courses.domain.Course;
import com.solution.shared.domain.DomainCreatedBy;
import com.solution.shared.domain.Service;
import com.solution.academy.categories.domain.*;
import org.springframework.context.ApplicationContext;

@Service
public final class CategoryCreator {
    private final ApplicationContext context;
    private final ICategoryRepository repository;

    public CategoryCreator(ApplicationContext context, ICategoryRepository repository) {
        this.context = context;
        this.repository = repository;
    }


    public void crear(String id, String name   , String description) {

        Category category = Category.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();


        repository.find(id).map(Category::getId).ifPresent(x -> {
            throw  new CategoryExist(id);
        });
        repository.save(category);

    }
}
