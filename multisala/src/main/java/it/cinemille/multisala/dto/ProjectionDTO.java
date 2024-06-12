package it.cinemille.multisala.dto;

import it.cinemille.multisala.entity.Projection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProjectionDTO {

    private Long id;
    private AuditoriumDTO auditorium;
    private MovieDTO movie;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProjectionDTO(Projection projection) {
        this.id = projection.getId();
        this.auditorium = new AuditoriumDTO(projection.getAuditorium());
        this.movie = new MovieDTO(projection.getMovie());
        this.startDate = projection.getStartDate();
        this.endDate = projection.getEndDate();
    }
}
