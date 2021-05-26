package com.solution.ventas.categoria.application.find;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.query.QueryHandler;
import com.solution.ventas.categoria.application.CategoriaResponse;
import com.solution.ventas.categoria.domain.CategoriaId;

@Service
public final class FindCategoriaQueryHandler implements QueryHandler<FindCategoriaQuery, CategoriaResponse> {
 private final FinderCateriaService service;

    public FindCategoriaQueryHandler(FinderCateriaService service) {
        this.service = service;
    }

    @Override
    public CategoriaResponse handle(FindCategoriaQuery query) {
        return service.finde(new CategoriaId(query.id()));
    }
}
