package com.solution.academy.categories.domain;

import com.solution.shared.domain.DomainError;

public final class CategoryExist extends DomainError {
    public CategoryExist(String id) {
        super("categoria_exist", String.format("The category <%s> exist", id));
    }
}
