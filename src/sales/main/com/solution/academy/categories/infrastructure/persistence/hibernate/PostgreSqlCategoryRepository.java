package com.solution.academy.categories.infrastructure.persistence.hibernate;

import com.solution.academy.categories.domain.Category;
import com.solution.academy.categories.domain.ICategoryRepository;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional("sales-transaction_manager")
public class PostgreSqlCategoryRepository extends HibernateRepository<Category> implements ICategoryRepository {
    public PostgreSqlCategoryRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Category.class);
    }
    @Override
    public void save(Category category) {
        persist(category);
    }

    @Override
    public List<Category> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<Category> find(String id) {
        return byId(id);
    }
}
