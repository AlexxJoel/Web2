package com.example.demo.modules.movie.service;

import com.example.demo.modules.movie.model.MovieRepository;
import com.example.demo.modules.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

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

    @Transactional(rollbackFor = { SQLException.class, Exception.class})
    public Movie save(Movie movie){
        return this.ImovieRepository.saveAndFlush(movie);
    }
}
