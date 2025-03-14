package fr.esgi.avis.usecase.exception;

public class EditeurNotFoundException extends NotFoundException {
    public EditeurNotFoundException(Long id){
        super("Impossible de trouver l'éditeur possédant l'id " + id);
    }
}
