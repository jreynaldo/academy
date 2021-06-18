package com.solution.academy.courses.application.create;


import com.solution.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CreateCourseCommand implements Command {
    private  String id;
    private  String name;
    private  String duration;
    private String categoryId;


}
