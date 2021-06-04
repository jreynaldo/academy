package com.solution.sales.product.application.find;

import com.solution.sales.categories.application.CategoryResponse;
import com.solution.sales.categories.domain.CategoryId;
import com.solution.sales.product.application.ProductResponse;
import com.solution.sales.product.domain.ProductId;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;

@Service
public final class FindProductQueryHandler implements QueryHandler<FindProductQuery, ProductResponse> {
 private final FinderProductService service;

    public FindProductQueryHandler(FinderProductService service) {
        this.service = service;
    }

    @Override
    public ProductResponse handle(FindProductQuery query) {
        return service.find(new ProductId(query.id()));
    }
}
