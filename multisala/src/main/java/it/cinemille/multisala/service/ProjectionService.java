package it.cinemille.multisala.service;

import it.cinemille.multisala.dto.ProjectionDTO;
import it.cinemille.multisala.entity.Projection;
import it.cinemille.multisala.repository.AuditoriumRepository;
import it.cinemille.multisala.repository.MovieRepository;
import it.cinemille.multisala.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ProjectionService {

    @Autowired
    private ProjectionRepository projectionRepo;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Flux<ProjectionDTO> findAllCurrentProjections(String sort, String dir) {
        return retrieveProjectionInfo(
                this.projectionRepo
                        .findByStartDateBeforeAndEndDateAfter(LocalDate.now(), LocalDate.now(), this.getSortDirection(sort, dir))
        );
    }

    public Flux<ProjectionDTO> findAllProjections(String sort, String dir) {
        return this.retrieveProjectionInfo(
                this.projectionRepo.findAll(this.getSortDirection(sort, dir))
        );
    }

    private Sort getSortDirection(String sort, String dir) {
        return Sort.by(Sort.Direction.valueOf(dir), sort);
    }

    private Flux<ProjectionDTO> retrieveProjectionInfo(Flux<Projection> proj) {
        return proj.flatMap(projection ->
                Mono.just(projection)
                        .zipWith(movieRepo.findById(projection.getIdMovie()))
                        .map(tuple -> {
                            tuple.getT1().setMovie(tuple.getT2());
                            return tuple.getT1();
                        })
                        .zipWith(auditoriumRepository.findById(projection.getIdAuditorium()))
                        .map(tuple -> {
                            tuple.getT1().setAuditorium(tuple.getT2());
                            return tuple.getT1();
                        })
                        .map(ProjectionDTO::new));
    }

}
