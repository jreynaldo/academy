package com.solution.apps.academy.backend;

import com.solution.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.solution.shared","com.solution.apps", "com.solution.sales"}
)
public class AcademyBackendApplication {
 /*   public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {{
        }};
    }*/

    public static void main(String[] args) {
        SpringApplication.run(AcademyBackendApplication.class, args);
    }
}
