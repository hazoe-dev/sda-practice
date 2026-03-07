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

    record FieldConfig(String column, String operation) {
    }

    private static final Map<String, FieldConfig> ALLOWED_FIELDS = Map.of(
            "title", new FieldConfig("title", "count"),
            "author", new FieldConfig("author", "count"),
            "description", new FieldConfig("description", "count"),
            "price", new FieldConfig("price", "sum"),
            "category", new FieldConfig("category", "count"),
            "downloadNums", new FieldConfig("download_nums", "sum"),
            "purchaseNums", new FieldConfig("purchase_nums", "sum"),
            "viewNums", new FieldConfig("view_nums", "sum"),
            "yearOfPublication", new FieldConfig("year_of_publication", "sum")
    );

    public long totalByField(String field) {
        FieldConfig config = ALLOWED_FIELDS.get(field);

        if (config == null) {
            throw new IllegalArgumentException("Field " + field + " is not allowed");
        }

        Number result;

        if ("count".equalsIgnoreCase(config.operation())) {
            result = countByField(config.column());
        } else if ("sum".equalsIgnoreCase(config.operation())) {
            result = sumByField(config.column());
        } else {
            throw new IllegalStateException("Unsupported operation");
        }

        return result == null ? 0 : result.longValue();
    }

    public Number countByField(String column) {
        String sql = "SELECT COUNT(" + column + ") FROM book";
        Query query = entityManager.createNativeQuery(sql);
        return (Number) query.getSingleResult();
    }

    public Number sumByField(String column) {
        String sql = "SELECT COALESCE(SUM(" + column + "),0) FROM book";
        Query query = entityManager.createNativeQuery(sql);
        return (Number) query.getSingleResult();
    }

}
