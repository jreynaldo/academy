package com.solution.academy.courses.application.create;


import com.solution.academy.courses.domain.CourseDuration;
import com.solution.academy.courses.domain.CourseId;
import com.solution.academy.courses.domain.CourseName;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {
    private final CourseCreator creator;

    public CreateCourseCommandHandler(CourseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCourseCommand command) {


        creator.create(command.getId(), command.getName(), command.getDuration(), command.getCategoryId());
    }
}
