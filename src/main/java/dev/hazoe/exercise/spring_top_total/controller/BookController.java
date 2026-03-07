package dev.hazoe.exercise.spring_top_total.controller;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import dev.hazoe.exercise.spring_top_total.dto.CountResponse;
import dev.hazoe.exercise.spring_top_total.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/top/{limit}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getTopBooksByField(@PathVariable int limit,
                                  @RequestParam String field) {
        return bookService.getTopByField(limit, field);
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    public CountResponse getTotalBooksBy(@RequestParam String field) {
        return bookService.getTotalBy(field);
    }
}
