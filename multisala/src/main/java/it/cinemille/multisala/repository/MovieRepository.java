package it.cinemille.multisala.repository;

import it.cinemille.multisala.entity.Movie;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends R2dbcRepository<Movie, Long> {
}
