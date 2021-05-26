package com.solution.apps.sales.backend;

import com.solution.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.solution.shared","com.solution.apps", "com.solution.sales"}
)
public class SalesBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {{
        }};
    }
}
