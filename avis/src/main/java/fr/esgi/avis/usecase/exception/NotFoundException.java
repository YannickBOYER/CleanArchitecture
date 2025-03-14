package fr.esgi.avis.usecase.exception;

public class NotFoundException extends RuntimeException {
    NotFoundException(String message){
        super(message);
    }
}
