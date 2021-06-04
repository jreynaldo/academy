package com.solution.apps.sales.backend.controllers.category;


import com.solution.sales.categories.domain.CategoryExist;
import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;

import com.solution.shared.infrastructure.spring.ApiController;

import com.solution.sales.categories.application.create.CreateCategoryCommand;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CreateCategoryPutController extends ApiController {
    public CreateCategoryPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request){
        System.out.println(id);
        dispatch(new CreateCategoryCommand(id, request.name(), request.description()));
          return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {

        return new HashMap<>(){{
            put(CategoryExist.class, HttpStatus.ACCEPTED);
        }};
    }

   static final class Request{

        private String name;
        private String description;

        public Request() {
        }

        public Request(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String name() {
            return name;
        }

        public String description() {
            return description;
        }


       public void setName(String name) {
           this.name = name;

       }

       public void setDescription(String description) {
           this.description = description;
       }
   }
}
