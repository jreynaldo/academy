package com.solution.sales.product.domain;



import com.solution.sales.categories.domain.CategoryId;
import com.solution.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
   void save(Product product);


   List<Product> matching(Criteria criteria);

   Optional<Product> find(ProductId id);

}
