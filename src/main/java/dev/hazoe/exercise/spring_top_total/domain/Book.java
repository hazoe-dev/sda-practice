package dev.hazoe.exercise.spring_top_total.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String description;
    private Double price;
    private String category;
    private int downloadNums;
    private int purchaseNums;
    private int viewNums;
    private Integer yearOfPublication;

}
