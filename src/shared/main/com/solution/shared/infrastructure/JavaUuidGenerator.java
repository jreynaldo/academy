package com.solution.shared.infrastructure;

import com.solution.shared.domain.Service;
import com.solution.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
