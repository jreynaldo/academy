package com.solution.sales.product.domain;

import com.solution.shared.domain.DomainError;

public final class ProductExist extends DomainError {

    public ProductExist(ProductId id) {
        super("product_exist", String.format("The product <%s> exist", id.value()));

    }
}
