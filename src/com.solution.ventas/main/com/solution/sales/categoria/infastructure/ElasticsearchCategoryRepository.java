package com.solution.sales.categoria.infastructure;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchClient;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchRepository;
import com.solution.sales.categoria.domain.Category;
import com.solution.sales.categoria.domain.CategoryId;
import com.solution.sales.categoria.domain.ICategoryRepository;


import java.util.List;
import java.util.Optional;


@Service
public final class ElasticsearchCategoryRepository extends ElasticsearchRepository<Category>  implements ICategoryRepository {
    public ElasticsearchCategoryRepository(ElasticsearchClient client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "categorias";
    }


    @Override
    public void save(Category category) {
        this.persist(category.id().value(), category.toPrimitives());

    }

    @Override
    public List<Category> searchAll() {
        return super.searchAllInElastic(Category::fromPrimitives);
    }

    @Override
    public List<Category> matching(Criteria criteria) {
        return super.searchByCriteria(criteria, Category::fromPrimitives);
    }

    @Override
    public Optional<Category> find(CategoryId id) {

        return super.byId(id, Category::fromPrimitives);
    }
}
