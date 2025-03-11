package fr.esgi.avis.controller.rest.advice;

import fr.esgi.avis.usecase.exception.EditeurNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EditeurRestControllerAdvice {
    @ExceptionHandler(EditeurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEditeurNotFoundException(EditeurNotFoundException e){
        return e.getMessage();
    }
}
