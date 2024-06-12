package it.cinemille.multisala.controller.advice;

import it.cinemille.multisala.exception.NoResultException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Void> handleNoResultException() {
        var response = ResponseEntity.notFound();
        return response.build();
    }
}
