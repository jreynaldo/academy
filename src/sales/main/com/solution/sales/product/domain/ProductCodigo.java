package com.solution.sales.product.domain;

import com.solution.shared.domain.StringValueObject;

public final class ProductCodigo extends StringValueObject {
    public ProductCodigo(String value) {
        super(value);
    }

    public ProductCodigo() {
        super("");
    }
}
