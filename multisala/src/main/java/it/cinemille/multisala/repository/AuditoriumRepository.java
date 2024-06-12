package it.cinemille.multisala.repository;

import it.cinemille.multisala.entity.Auditorium;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends R2dbcRepository<Auditorium, Long> {
}
