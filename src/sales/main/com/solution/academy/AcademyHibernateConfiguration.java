package com.solution.academy;

import com.solution.shared.infrastructure.config.Parameter;
import com.solution.shared.infrastructure.config.ParameterNotExist;
import com.solution.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class AcademyHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter config;
    private final String                        CONTEXT_NAME = "sales";

    public AcademyHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("sales-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("sales-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("sales-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("SALES_DATABASE_HOST"),
            config.getInt("SALES_DATABASE_PORT"),
            config.get("SALES_DATABASE_NAME"),
            config.get("SALES_DATABASE_USER"),
            config.get("SALES_DATABASE_PASSWORD")
        );
    }
}
