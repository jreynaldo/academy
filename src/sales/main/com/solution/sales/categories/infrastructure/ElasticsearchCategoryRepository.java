package com.solution.sales.categories.infrastructure;

import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchClient;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchRepository;
import com.solution.sales.categories.domain.Category;
import com.solution.sales.categories.domain.CategoryId;


import java.util.List;
import java.util.Optional;


public final class ElasticsearchCategoryRepository extends ElasticsearchRepository<Category>
{
    public ElasticsearchCategoryRepository(ElasticsearchClient client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "categories";
    }



    public void save(Category category) {
        this.persist(category.id().value(), category.toPrimitives());

    }


    public List<Category> searchAll() {
        return super.searchAllInElastic(Category::fromPrimitives);
    }


    public List<Category> matching(Criteria criteria) {
        return super.searchByCriteria(criteria, Category::fromPrimitives);
    }


    public Optional<Category> find(CategoryId id) {

        return super.byId(id, Category::fromPrimitives);
    }
}
