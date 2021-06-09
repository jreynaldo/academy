package com.solution.sales.product.application.find;

import com.solution.sales.categories.application.CategoryResponse;
import com.solution.sales.categories.domain.CategoryId;
import com.solution.sales.categories.domain.ICategoryRepository;
import com.solution.sales.product.application.ProductResponse;
import com.solution.sales.product.domain.*;
import com.solution.shared.domain.Service;

@Service
public final class FinderProductService {
    private final IProductRepository repository;

    public FinderProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse find(ProductId id){
        Product producto = repository.find(id).orElseThrow(() -> new ProductNotExist(id));
        return ProductResponse.fromAggregate(producto);
    }
}
