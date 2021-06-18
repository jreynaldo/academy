package tv.codely.mooc.courses.infrastructure.persistence;

import com.solution.academy.courses.domain.Course;
import com.solution.academy.courses.domain.CourseId;
import com.solution.academy.courses.domain.CourseRepository;
import com.solution.shared.domain.Service;
import com.solution.shared.domain.criteria.Criteria;
import com.solution.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlCourseRepository extends HibernateRepository<Course> implements CourseRepository {
    public MySqlCourseRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Course.class);
    }

    @Override
    public void save(Course course) {
        persist(course);
    }

    @Override
    public Optional<Course> search(String id) {
        return byId(id);
    }

    @Override
    public List<Course> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
