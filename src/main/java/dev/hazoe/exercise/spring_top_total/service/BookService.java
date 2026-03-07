package dev.hazoe.exercise.spring_top_total.service;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import dev.hazoe.exercise.spring_top_total.dto.CountResponse;

import java.util.List;

public interface BookService {
    List<Book> getTopByField(int limit, String field);

    CountResponse getTotalBy(String field);
}
