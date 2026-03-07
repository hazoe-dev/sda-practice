package dev.hazoe.exercise.spring_top_total.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BookRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    enum Operation {
        COUNT {
            @Override
            Number execute(EntityManager em, String column) {
                String sql = "SELECT COUNT(" + column + ") FROM book";
                Query query = em.createNativeQuery(sql);
                return (Number) query.getSingleResult();
            }
        },
        SUM {
            @Override
            Number execute(EntityManager em, String column) {
                String sql = "SELECT COALESCE(SUM(" + column + "),0) FROM book";
                Query query = em.createNativeQuery(sql);
                return (Number) query.getSingleResult();
            }
        };

        abstract Number execute(EntityManager em, String column);
    }

    record FieldConfig(String column, Operation operation) {}

    private static final Map<String, FieldConfig> ALLOWED_FIELDS = Map.of(
            "title", new FieldConfig("title", Operation.COUNT),
            "author", new FieldConfig("author", Operation.COUNT),
            "description", new FieldConfig("description", Operation.COUNT),
            "price", new FieldConfig("price", Operation.SUM),
            "category", new FieldConfig("category", Operation.COUNT),
            "downloadNums", new FieldConfig("download_nums", Operation.SUM),
            "purchaseNums", new FieldConfig("purchase_nums", Operation.SUM),
            "viewNums", new FieldConfig("view_nums", Operation.SUM),
            "yearOfPublication", new FieldConfig("year_of_publication", Operation.SUM)
    );

    public long totalByField(String field) {
        FieldConfig config = ALLOWED_FIELDS.get(field);

        if (config == null) {
            throw new IllegalArgumentException("Field " + field + " is not allowed");
        }

        Number result = config.operation().execute(entityManager, config.column());

        return result == null ? 0 : result.longValue();
    }
}
