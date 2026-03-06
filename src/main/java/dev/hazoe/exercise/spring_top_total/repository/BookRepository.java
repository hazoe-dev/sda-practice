package dev.hazoe.exercise.spring_top_total.repository;

import dev.hazoe.exercise.spring_top_total.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
