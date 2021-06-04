package com.solution.sales.categories.domain;

import com.solution.shared.domain.*;
import com.solution.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Category extends AggregateRoot {
    private final CategoryId id;
    private final CategoryName name;
    private final CategoryDescription description;


    public Category() {
        super();
        id = null;
        name = null;
        description = null;
    }

    public Category(CategoryId id, CategoryName name, CategoryDescription description, DomainCreatedBy createBy) {
        super(createBy);
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Builder create(CategoryId id) {
        return new Builder(id);
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


    public HashMap<String, Serializable> toPrimitives() {
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
                new CategoryDescription(plainData.get("description").toString()),
                new DomainCreatedBy(plainData.get("createdBy").toString()));
    }


    public static final class Builder {
        private CategoryId id;
        private CategoryName name;
        private CategoryDescription description;
        private DomainCreatedBy createdBy;

        private Builder(CategoryId id) {
            this.id = id;
        }



        public Builder name(CategoryName name) {
            this.name = name;
            return this;
        }

        public Builder description(CategoryDescription description) {
            this.description = description;
            return this;
        }

        public Builder createdBy(DomainCreatedBy createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Category build() {
            Category category = new Category(id, name, description, createdBy);
            return category;
        }
    }
}