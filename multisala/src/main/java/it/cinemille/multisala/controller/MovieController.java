package it.cinemille.multisala.controller;

import it.cinemille.multisala.dto.MovieDTO;
import it.cinemille.multisala.dto.ProjectionDTO;
import it.cinemille.multisala.service.MovieService;
import it.cinemille.multisala.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movies")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ProjectionService projectionService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MovieDTO> getMovieById(@PathVariable Long id) {
        return this.movieService.getById(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProjectionDTO> getAllProjections(@RequestParam String sort, @RequestParam String dir) {
        return this.projectionService.findAllProjections(sort, dir);
    }

    @GetMapping("/current")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProjectionDTO> getAllCurrentProjections(@RequestParam String sort, @RequestParam String dir) {
        return this.projectionService.findAllCurrentProjections(sort, dir);
    }
}
