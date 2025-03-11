package fr.esgi.avis.usecase.exception;

public class EditeurNotFoundException extends RuntimeException{
    public EditeurNotFoundException(Long id){
        super("Impossible de trouver le genre possédant l'id " + id);
    }
}
