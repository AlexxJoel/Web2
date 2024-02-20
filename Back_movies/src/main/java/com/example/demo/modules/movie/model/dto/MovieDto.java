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

    @NotNull(groups = {getByDirectorName.class})
    private String director;

    @NotNull(groups = {getByDate.class})
    private LocalDate atPublish;

    private Boolean status = true;

    @NotNull(groups = {getByCategory.class})
    private Category category;

    @NotNull(groups = {getByDates.class})
    private LocalDate atPublishStart;
    @NotNull(groups = {getByDates.class})
    private LocalDate atPublishEnd;


    interface getAll{};
    interface save{};
    public interface getByTitle{};
    public interface getByDirectorName{};
    public interface getByDates{};
    public interface getByCategory{};

    public interface getByDate{};

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", atPublish=" + atPublish +
                ", status=" + status +
                ", category=" + category +
                ", atPublishStart=" + atPublishStart +
                ", atPublishEnd=" + atPublishEnd +
                '}';
    }
}
