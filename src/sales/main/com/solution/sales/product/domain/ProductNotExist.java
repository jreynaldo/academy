package com.solution.sales.product.domain;

import com.solution.shared.domain.DomainError;

public final class ProductNotExist extends DomainError {

    public ProductNotExist(ProductId id) {
        super("product_not_exist", String.format("The product <%s> Not Exist", id.value()));

    }
}
