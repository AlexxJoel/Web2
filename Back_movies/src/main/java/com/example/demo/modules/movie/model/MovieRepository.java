package com.example.demo.modules.movie.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository

public interface MovieRepository extends JpaRepository<Movie, Long>{
        Page<Movie> findAll(Pageable pageable);
        Page<Movie> findAllByTitleContainingIgnoreCase (Pageable pageable, String title);
        Page<Movie> findAllByDirectorContainingIgnoreCase(Pageable pageable, String nameDirector);
        Page<Movie> findAllByAtPublishBetween(LocalDate atPublishStart, LocalDate atPublishEnd, Pageable pageable);
        Page<Movie> findAllByCategoryId(Long category, Pageable pageable);
        Page<Movie> findByAtPublishAfterOrderByAtPublishDesc(LocalDate atPublish, Pageable pageable);


}
