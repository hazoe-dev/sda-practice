package dev.hazoe.exercise.spring_top_total.service.impl;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import dev.hazoe.exercise.spring_top_total.dto.CountResponse;
import dev.hazoe.exercise.spring_top_total.exception.ResourceNotFoundException;
import dev.hazoe.exercise.spring_top_total.repository.BookRepository;
import dev.hazoe.exercise.spring_top_total.repository.BookRepositoryCustom;
import dev.hazoe.exercise.spring_top_total.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookRepositoryCustom repositoryCustom;

    private static final Set<String> ALLOWED_COUNT_FIELDS = Set.of(
            "title", "author", "description",
            "price", "category", "downloadNums", "purchaseNums", "viewNums",
            "yearOfPublication"
    );

    private static final Map<String, Sort.Direction> SORT_FIELDS = Map.of(
            "title", Sort.Direction.ASC,
            "author", Sort.Direction.ASC,
            "description", Sort.Direction.ASC,
            "price", Sort.Direction.DESC,
            "category", Sort.Direction.ASC,
            "downloadNums", Sort.Direction.DESC,
            "purchaseNums", Sort.Direction.DESC,
            "viewNums", Sort.Direction.DESC,
            "yearOfPublication", Sort.Direction.DESC
    );

    @Override
    public List<Book> getTopByField(int limit, String field) {
        if (limit < 1) {
            throw new IllegalArgumentException("limit must be greater than 0");
        }

        if (!SORT_FIELDS.containsKey(field)) {
            throw new IllegalArgumentException(String.format("field %s not found", field));
        }

        Sort.Direction direction = getSortDirection(field);

        Pageable pageable = PageRequest.of(
                0,
                limit,
                Sort.by(direction, field));


        List<Book> foundBooks = repository.findAll(pageable).getContent();

        if (foundBooks.isEmpty()) {
            throw new ResourceNotFoundException(String.format("no books found with field %s", field));
        }
        return foundBooks;
    }

    private Sort.Direction getSortDirection(String field) {
        Sort.Direction direction = SORT_FIELDS.get(field);
        if (direction == null) {
            throw new IllegalArgumentException("Invalid field: " + field);
        }
        return direction;
    }

    @Override
    public List<CountResponse> getTotalBy(String field) {
        if (!SORT_FIELDS.containsKey(field)) {
            throw new IllegalArgumentException(String.format("field %s not found", field));
        }

        List<Object[]> rows = repositoryCustom.countByField(field);

        if (rows.isEmpty()) {
            throw new ResourceNotFoundException(String.format("no books found with field %s", field));
        }

        return rows.stream()
                .map(r -> new CountResponse(
                        String.valueOf(r[0]),
                        ((Number) r[1]).longValue())
                )
                .toList();
    }
}
