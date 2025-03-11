package fr.esgi.avis.business.exception;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(Long id){
        super("Impossible de trouver le genre possédant l'id " + id);
    }
}
