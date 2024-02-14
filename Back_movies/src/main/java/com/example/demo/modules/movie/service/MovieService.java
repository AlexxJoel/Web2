package com.example.demo.modules.movie.service;

import com.example.demo.modules.movie.model.MovieRepository;
import com.example.demo.modules.movie.model.Movie;
import com.example.demo.modules.movie.model.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    private final MovieRepository ImovieRepository;

    public MovieService(MovieRepository imovieRepository) {
        ImovieRepository = imovieRepository;
    }

    @Transactional(readOnly = true)
    public Page<Movie> findAll(Pageable pageable) {
        return this.ImovieRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Movie> findByTitle(Pageable pageable, MovieDto data) {
        return this.ImovieRepository.findAllByTitleIgnoreCase(pageable, data.getTitle());
    }

    @Transactional(rollbackFor = { SQLException.class, Exception.class})
    public Movie save(Movie movie){
        return this.ImovieRepository.saveAndFlush(movie);
    }

    @Transactional(rollbackFor = { SQLException.class, Exception.class})
    public Movie update(Movie movie){
        return this.ImovieRepository.saveAndFlush(movie);
    }

    @Transactional(rollbackFor = { SQLException.class, Exception.class})
    public Movie changeStatus(Long id){
        Movie movie = this.ImovieRepository.findById(id).get();
        movie.setStatus(!movie.getStatus());
        return this.ImovieRepository.saveAndFlush(movie);
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id){
        return this.ImovieRepository.findById(id);
    }
}
