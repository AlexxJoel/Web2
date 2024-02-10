package com.example.demo.modules.movie.controller;

import com.example.demo.modules.movie.model.Movie;
import com.example.demo.modules.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movie")
@CrossOrigin(origins = {"*"})
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/")
    public Page<Movie> getAll(Pageable pageable) {
        return this.movieService.findAll(pageable);
    }

    @PostMapping("/")
    public Movie save(@RequestBody Movie movie) {
        return this.movieService.save(movie);
    }


}
