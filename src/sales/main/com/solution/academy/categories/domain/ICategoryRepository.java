package com.solution.academy.categories.domain;


import com.solution.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
   void save(Category category);



   List<Category> matching(Criteria criteria);

   Optional<Category> find(String id);

}
