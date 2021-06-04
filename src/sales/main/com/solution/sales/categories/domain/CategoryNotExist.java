package com.solution.sales.categories.domain;

import com.solution.shared.domain.DomainError;

public final class CategoryNotExist extends DomainError {
    public CategoryNotExist(CategoryId id) {
        super("categoria_not_exist", String.format("The category <%s> doesn't exist", id.value()));
    }
}
