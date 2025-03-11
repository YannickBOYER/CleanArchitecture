package fr.esgi.avis.business.exception.notfound;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException(Long id){
        super("Impossible de trouver le genre possédant l'id " + id);
    }
}
