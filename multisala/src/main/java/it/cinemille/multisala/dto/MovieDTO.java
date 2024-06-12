package it.cinemille.multisala.dto;

import it.cinemille.multisala.entity.Movie;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.imageUrl = movie.getImageUrl();
    }
}
