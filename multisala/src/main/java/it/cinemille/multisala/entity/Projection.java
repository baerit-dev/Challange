package it.cinemille.multisala.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
public class Projection {

    @Id
    private Long id;
    @Column("id_movie")
    private Long idMovie;
    @Column("id_auditorium")
    private Long idAuditorium;
    @Column("start_date")
    private LocalDate startDate;
    @Column("end_date")
    private LocalDate endDate;

    @Transient
    private Movie movie;
    @Transient
    private Auditorium auditorium;
}
