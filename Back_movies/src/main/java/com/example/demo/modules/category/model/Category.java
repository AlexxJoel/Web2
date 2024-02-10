package com.example.demo.modules.category.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.demo.modules.movie.model.Movie;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String image;


    @Column(columnDefinition = "BOOLEAN DEFAULT true", nullable = false)
    private boolean status;

    @JsonIgnoreProperties({"category"})
    @OneToMany(mappedBy = "category")
    private List<Movie> movies;



}
