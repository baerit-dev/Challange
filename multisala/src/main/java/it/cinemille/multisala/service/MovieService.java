package it.cinemille.multisala.service;

import it.cinemille.multisala.dto.MovieDTO;
import it.cinemille.multisala.exception.NoResultException;
import it.cinemille.multisala.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repo;

    public Mono<MovieDTO> getById(final Long id) {
        return this.repo.findById(id).switchIfEmpty(Mono.error(new NoResultException())).map(MovieDTO::new);
    }
}
