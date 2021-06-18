package com.solution.academy.students.application.create;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.bus.command.CommandHandler;

@Service
public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {
    private final StudentCreator creator;

    public CreateStudentCommandHandler(StudentCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateStudentCommand command) {
            creator.create(command.getId(), command.getEmail(),command.getPassword());
    }
}
