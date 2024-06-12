package it.cinemille.multisala.repository;

import it.cinemille.multisala.entity.Projection;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface ProjectionRepository extends R2dbcRepository<Projection, Long> {

    Flux<Projection> findByStartDateBeforeAndEndDateAfter(LocalDate startDate, LocalDate endDate, Sort sort);
}
