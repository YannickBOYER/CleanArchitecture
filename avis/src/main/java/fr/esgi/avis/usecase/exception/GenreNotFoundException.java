package fr.esgi.avis.usecase.exception;

public class GenreNotFoundException extends NotFoundException{
    public GenreNotFoundException(Long id){
        super("Impossible de trouver le genre possédant l'id " + id);
    }
}
