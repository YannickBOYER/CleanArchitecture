package fr.esgi.avis.usecase.exception;

public class ClassificationNotFoundException extends NotFoundException{
    public ClassificationNotFoundException(Long id){
        super("Impossible de trouver la classification possédant l'id " + id);
    }
}
