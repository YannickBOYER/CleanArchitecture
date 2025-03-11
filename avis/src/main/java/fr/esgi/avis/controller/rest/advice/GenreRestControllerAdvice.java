package fr.esgi.avis.controller.rest.advice;

import fr.esgi.avis.business.exception.GenreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenreRestControllerAdvice {
    @ExceptionHandler(GenreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleGenreNotFoundException(GenreNotFoundException e){
        return e.getMessage();
    }
}
