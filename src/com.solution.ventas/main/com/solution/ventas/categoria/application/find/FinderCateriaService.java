package com.solution.ventas.categoria.application.find;

import com.solution.shared.domain.Service;
import com.solution.ventas.categoria.application.CategoriaResponse;
import com.solution.ventas.categoria.domain.CategoriaId;
import com.solution.ventas.categoria.domain.ICategoriaRepository;

@Service
public final class FinderCateriaService {
    private final ICategoriaRepository repository;

    public FinderCateriaService(ICategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaResponse finde(CategoriaId id){
        return CategoriaResponse.fromAggregate(repository.find(id).orElseThrow(() ->new RuntimeException("Error")));
    }
}
