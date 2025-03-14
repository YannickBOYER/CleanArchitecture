package fr.esgi.avis.usecase.exception;

public class JeuNotFoundException extends NotFoundException{
    public JeuNotFoundException(Long id){
        super("Impossible de trouver le jeu possédant l'id " + id);
    }
}
