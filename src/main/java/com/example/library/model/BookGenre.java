package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "book_genre")
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "genre_id")
    private Integer genreId;
}
