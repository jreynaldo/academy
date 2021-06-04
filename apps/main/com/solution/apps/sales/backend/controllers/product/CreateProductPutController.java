package com.solution.apps.sales.backend.controllers.product;


import com.solution.sales.product.application.create.CreateProductCommand;
import com.solution.sales.product.domain.ProductExist;
import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;
import com.solution.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class CreateProductPutController extends ApiController {
    public CreateProductPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) {
        System.out.println(id);
        dispatch(
                CreateProductCommand.create(id)
                        .codigo(request.codigo)
                        .nombre(request.nombre)
                        .descripcion(request.descripcion)
                        .imagen(request.imagen)
                        .categoriaId(request.categoriaId)
                        .presentacionId(request.presentacionId)
                .build()

        );
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {

        return new HashMap<>() {{
            put(ProductExist.class, HttpStatus.ACCEPTED);
        }};
    }

    static final class Request {

        private String codigo;
        private String nombre;
        private String descripcion;
        private String imagen;
        private String categoriaId;
        private String presentacionId;

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public void setCategoriaId(String categoriaId) {
            this.categoriaId = categoriaId;
        }

        public void setPresentacionId(String presentacionId) {
            this.presentacionId = presentacionId;
        }
    }

}


