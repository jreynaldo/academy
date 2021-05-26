package com.solution.sales.categoria.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class Category {
   private CategoryId id;
   private CategoryName name;
   private CategoryDescription description;

   public Category(CategoryId id, CategoryName name, CategoryDescription description) {
      this.id = id;
      this.name = name;
      this.description = description;
   }



   public CategoryId id() {
      return id;
   }



   public CategoryName nombre() {
      return name;
   }


   public CategoryDescription descripcion() {
      return description;
   }




    public HashMap<String, Serializable>  toPrimitives() {
       return new HashMap<>() {{
          put("id", id().value());
          put("name", name.value());
          put("description", description.value());
       }};
    }

   public static Category fromPrimitives(Map<String, Object> plainData) {
      return new Category(
              new CategoryId(plainData.get("id").toString()),
              new CategoryName(plainData.get("name").toString()),
              new CategoryDescription(plainData.get("description").toString())
      );
   }
}
