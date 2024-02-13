package com.example.demo.modules.movie.model;

import com.example.demo.modules.category.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private Boolean status = true;

    @ManyToOne
    @JsonIgnoreProperties("movies")
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
