package com.example.demo.modules.movie.model.dto;

import com.example.demo.modules.category.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;

    @NotNull(groups = {getByTitle.class})
    private String title;

    private String description;

    private String director;

    private LocalDate atPublish;

    private Boolean status = true;

    private Category category;

    interface getAll{};
    interface save{};
    public interface getByTitle{};


}
