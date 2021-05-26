package com.solution.apps.sales.backend.controllers.category;


import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;

import com.solution.shared.infrastructure.spring.ApiController;

import com.solution.sales.categoria.application.create.CreateCategoryCommand;

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

    @PutMapping("/categoria/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request){
        System.out.println(id);
        dispatch(new CreateCategoryCommand(id, request.nombre(), request.descripcion()));
          return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }

   static final class Request{

        private String nombre;
        private String descripcion;

        public Request() {
        }

        public Request(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public String nombre() {
            return nombre;
        }

        public String descripcion() {
            return descripcion;
        }


        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
