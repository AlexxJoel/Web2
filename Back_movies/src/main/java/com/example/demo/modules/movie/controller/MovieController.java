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
        return this.movieService.findAllByTitle(pageable, movie);
    }

    @PostMapping("/findByDirectorName")
    public Page<Movie> getByDirectorName(@Validated({MovieDto.getByDirectorName.class}) @RequestBody MovieDto movieDto, Pageable pageable){
        return this.movieService.findAllByDirectorName(pageable, movieDto);
    }
    @PostMapping("findBetweenDates")
    public Page<Movie> getByDateBetween(@Validated({MovieDto.getByDates.class}) @RequestBody MovieDto movieDto, Pageable pageable){
        return this.movieService.findAllByDateBetween(pageable, movieDto);
    }
    @PostMapping("findByCategory")
    public Page<Movie> getByCategory(@Validated({MovieDto.getByCategory.class}) @RequestBody MovieDto movieDto, Pageable pageable){
        return this.movieService.findAllByCategory(pageable, movieDto);
    }
    @PostMapping("findByDate")
    public Page<Movie> getByDate(@Validated({MovieDto.getByDate.class}) @RequestBody MovieDto movieDto, Pageable pageable){
        return this.movieService.findAllByDate(pageable, movieDto);
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
