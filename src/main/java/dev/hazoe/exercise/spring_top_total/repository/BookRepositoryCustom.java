package dev.hazoe.exercise.spring_top_total.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> countByField(String field) {
        String sql = "Select " + field + ", count(*) from Book group by " + field;
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
