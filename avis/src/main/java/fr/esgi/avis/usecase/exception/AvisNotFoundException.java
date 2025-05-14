package fr.esgi.avis.usecase.exception;

public class AvisNotFoundException extends NotFoundException{
    public AvisNotFoundException(Long id) {
        super("Impossible de trouver l'avis possédant l'id " + id);
    }
}
