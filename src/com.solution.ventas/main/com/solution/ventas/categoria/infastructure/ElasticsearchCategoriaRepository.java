package com.solution.ventas.categoria.infastructure;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchClient;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchRepository;
import com.solution.ventas.categoria.domain.Categoria;
import com.solution.ventas.categoria.domain.CategoriaId;
import com.solution.ventas.categoria.domain.ICategoriaRepository;


import java.util.List;
import java.util.Optional;


@Service
public final class ElasticsearchCategoriaRepository extends ElasticsearchRepository<Categoria>  implements ICategoriaRepository {
    public ElasticsearchCategoriaRepository(ElasticsearchClient client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "categorias";
    }


    @Override
    public void save(Categoria categoria) {
        this.persist(categoria.id().value(),categoria.toPrimitives());

    }

    @Override
    public List<Categoria> searchAll() {
        return super.searchAllInElastic(Categoria::fromPrimitives);
    }

    @Override
    public List<Categoria> matching(Criteria criteria) {
        return super.searchByCriteria(criteria,Categoria::fromPrimitives);
    }

    @Override
    public Optional<Categoria> find(CategoriaId id) {

        return super.byId(id,Categoria::fromPrimitives);
    }
}
