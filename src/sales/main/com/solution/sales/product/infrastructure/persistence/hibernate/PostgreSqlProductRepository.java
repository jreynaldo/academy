package com.solution.sales.product.infrastructure.persistence.hibernate;

import com.solution.sales.categories.domain.Category;
import com.solution.sales.categories.domain.CategoryId;
import com.solution.sales.categories.domain.ICategoryRepository;
import com.solution.sales.product.domain.IProductRepository;
import com.solution.sales.product.domain.Product;
import com.solution.sales.product.domain.ProductId;
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
public class PostgreSqlProductRepository extends HibernateRepository<Product> implements IProductRepository {
    public PostgreSqlProductRepository(@Qualifier("sales-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Product.class);
    }
    @Override
    public void save(Product product) {
        persist(product);
    }


    @Override
    public List<Product> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<Product> find(ProductId id) {
        return byId(id);
    }
}
