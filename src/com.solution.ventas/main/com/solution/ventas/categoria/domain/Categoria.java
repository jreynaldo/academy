package com.solution.ventas.categoria.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class Categoria {
   private CategoriaId id;
   private CategoriaNombre nombre;
   private CategoriaDescripcion descripcion;

   public Categoria(CategoriaId id, CategoriaNombre nombre, CategoriaDescripcion descripcion) {
      this.id = id;
      this.nombre = nombre;
      this.descripcion = descripcion;
   }



   public CategoriaId id() {
      return id;
   }



   public CategoriaNombre nombre() {
      return nombre;
   }


   public CategoriaDescripcion descripcion() {
      return descripcion;
   }




    public HashMap<String, Serializable>  toPrimitives() {
       return new HashMap<>() {{
          put("id", id().value());
          put("nombre", nombre.value());
          put("descripcion", descripcion.value());
       }};
    }

   public static Categoria fromPrimitives(Map<String, Object> plainData) {
      return new Categoria(
              new CategoriaId(plainData.get("id").toString()),
              new CategoriaNombre(plainData.get("nombre").toString()),
              new CategoriaDescripcion(plainData.get("descripcion").toString())
      );
   }
}
