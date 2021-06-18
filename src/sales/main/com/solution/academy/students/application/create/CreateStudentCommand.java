package com.solution.academy.students.application.create;

import com.solution.shared.domain.bus.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateStudentCommand implements Command {
    private String id;
    private String email;
    private String password;
}
