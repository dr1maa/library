package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Column(name = "publisher_name")
    private String publisherName;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;


}
