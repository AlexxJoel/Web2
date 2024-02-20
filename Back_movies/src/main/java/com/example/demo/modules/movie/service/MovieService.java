package com.example.demo.modules.movie.service;

import com.example.demo.modules.movie.model.MovieRepository;
import com.example.demo.modules.movie.model.Movie;
import com.example.demo.modules.movie.model.dto.MovieDto;
import jakarta.transaction.TransactionScoped;
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
    public Page<Movie> findAllByTitle(Pageable pageable, MovieDto data) {
        return this.ImovieRepository.findAllByTitleContainingIgnoreCase(pageable, data.getTitle());
    }
    @Transactional(readOnly = true)
    public Page<Movie> findAllByDirectorName(Pageable pageable, MovieDto data){
        return this.ImovieRepository.findAllByDirectorContainingIgnoreCase(pageable, data.getDirector());
    }
    @Transactional(readOnly = true)
    public Page<Movie> findAllByDateBetween(Pageable pageable, MovieDto movieDto){
        return this.ImovieRepository.findAllByAtPublishBetween(movieDto.getAtPublishStart(), movieDto.getAtPublishEnd(), pageable);
    }

    @Transactional(readOnly = true)
    public Page<Movie> findAllByCategory(Pageable pageable, MovieDto movieDto){
        return this.ImovieRepository.findAllByCategoryId(movieDto.getCategory().getId(), pageable);
    }

    @Transactional(readOnly = true)
    public Page<Movie> findAllByDate(Pageable pageable, MovieDto movieDto){
        return this.ImovieRepository.findByAtPublishAfterOrderByAtPublishDesc(movieDto.getAtPublish(), pageable);
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
