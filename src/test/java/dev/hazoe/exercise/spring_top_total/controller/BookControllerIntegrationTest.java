package dev.hazoe.exercise.spring_top_total.controller;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import dev.hazoe.exercise.spring_top_total.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setup() {
        bookRepository.deleteAll();

        Book b1 = new Book();
        b1.setTitle("Java");
        b1.setPrice(10.0);
        b1.setDownloadNums(100);

        Book b2 = new Book();
        b2.setTitle("Spring");
        b2.setPrice(20.0);
        b2.setDownloadNums(50);

        Book b3 = new Book();
        b3.setTitle("Docker");
        b3.setPrice(0.0);
        b3.setDownloadNums(10);

        bookRepository.saveAll(List.of(b1, b2, b3));

    }

    @Test
    void shouldReturnTotalBooks_withFieldUsesSumOperator() throws Exception {

        mockMvc.perform(get("/books/total")
                        .param("field", "price"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(30))
                .andExpect(jsonPath("$.field").value("price"));
    }

    @Test
    void shouldReturnTotalBooks_withFieldUsesCountOperator() throws Exception {

        mockMvc.perform(get("/books/total")
                        .param("field", "title"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(3))
                .andExpect(jsonPath("$.field").value("title"));
    }

    @Test
    void shouldReturnTopBooks() throws Exception {

        mockMvc.perform(get("/books/top/2")
                        .param("field", "downloadNums"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Java"))
                .andExpect(jsonPath("$[1].title").value("Spring"));
    }
}