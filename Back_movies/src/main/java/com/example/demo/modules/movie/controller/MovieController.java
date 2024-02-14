package com.example.demo.modules.movie.controller;

import com.example.demo.modules.movie.model.Movie;
import com.example.demo.modules.movie.model.dto.MovieDto;
import com.example.demo.modules.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/findByTitle")
    public Page<Movie>  getByTitle(@Validated({MovieDto.getByTitle.class}) @RequestBody MovieDto movie, Pageable pageable) {
        return this.movieService.findByTitle(pageable, movie);
    }

    @PostMapping("/")
    public Movie save(@RequestBody Movie movie) {
        return this.movieService.save(movie);
    }

    @PutMapping("/update/")
    public Movie update( @RequestBody Movie movie) {
        movie.setId(movie.getId());
        return this.movieService.update(movie);
    }

    @PatchMapping("/change-status/{id}")
    public Movie changeStatus(@PathVariable Long id) {
        return this.movieService.changeStatus(id);
    }


}
