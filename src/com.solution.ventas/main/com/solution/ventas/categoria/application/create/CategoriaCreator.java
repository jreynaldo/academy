package com.solution.ventas.categoria.application.create;

import com.solution.shared.domain.Service;
import com.solution.ventas.categoria.domain.*;
import com.solution.ventas.categoria.infastructure.ElasticsearchCategoriaRepository;
import org.elasticsearch.client.license.LicensesStatus;

import java.util.List;

@Service
public final class CategoriaCreator {

    private final ElasticsearchCategoriaRepository repository;

    public CategoriaCreator(ElasticsearchCategoriaRepository repository) {
        this.repository = repository;
    }


    public void crear(CategoriaId id, CategoriaNombre nombre   , CategoriaDescripcion descripcion) {

        Categoria categoria = CategoriaBuilder.crear()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .build();

        repository.save(categoria);

        List<Categoria> categorias = repository.searchAll();
        categorias.forEach(System.out::println);

    }
}
