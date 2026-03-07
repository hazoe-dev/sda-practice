package dev.hazoe.exercise.spring_top_total.controller;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import dev.hazoe.exercise.spring_top_total.dto.CountResponse;
import dev.hazoe.exercise.spring_top_total.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
@ContextConfiguration(classes = BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvcTester mvcTester;

    @MockitoBean
    private BookService bookService;

    @Test
    void shouldReturnTopBooks(){
        Book book1 = new Book();
        Book book2 = new Book();

        book1.setId(1L);
        book1.setTitle("Clean Code");

        book2.setId(2L);
        book2.setTitle("Spring");

        List<Book> books = List.of(book1,book2);

        when(bookService.getTopByField(2, "price"))
                .thenReturn(books);

        mvcTester.get()
                .uri("/books/top/2?field=price")
                .assertThat()
                .hasStatusOk()
                .bodyJson()
                .extractingPath("$[0].title").isEqualTo("Clean Code");

    }
    @Test
    void shouldReturnTotalBooks() {
        CountResponse result =new CountResponse("price", 2);

        when(bookService.getTotalBy("price"))
                .thenReturn(result);

        mvcTester.get()
                .uri("/books/total?field=price")
                .assertThat()
                .hasStatusOk()
                .bodyJson()
                .extractingPath("$.total")
                .isEqualTo(2);
    }
}