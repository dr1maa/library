package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer genreId;
    @Column(name = "genre_name")
    private String genreName;
    @ManyToMany(mappedBy = "genres")
    private List<Book> books;

}
