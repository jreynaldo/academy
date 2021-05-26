package com.solution.ventas.categoria.domain;


import com.solution.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaRepository {
   void save(Categoria categoria);

   List<Categoria> searchAll();

   List<Categoria> matching(Criteria criteria);

   Optional<Categoria> find(CategoriaId id);

}
