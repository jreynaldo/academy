package com.solution.apps.academy.backend.controller.curses;

import com.solution.academy.courses.application.create.CreateCourseCommand;
import com.solution.shared.domain.DomainError;
import com.solution.shared.domain.bus.command.CommandBus;
import com.solution.shared.domain.bus.query.QueryBus;
import com.solution.shared.infrastructure.spring.ApiController;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1")
public final class CreateCoursePostController extends ApiController {
    public CreateCoursePostController(
            QueryBus queryBus,
            CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping("/course")
    public ResponseEntity<String> index(@RequestBody Request request){
          dispatch(
                  CreateCourseCommand.builder()
                          .id(request.id)
                          .name(request.name)
                          .duration(request.duration)
                          .categoryId(request.categoryId)
                          .build()
          );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }

    @Data
    @AllArgsConstructor
    final class Request{

        private  String id;
        private  String name;
        private  String duration;
        private String categoryId;


    }

}