package fr.esgi.avis.usecase.exception;

public class JoueurNotFoundException extends NotFoundException{
    public JoueurNotFoundException(Long id) {
        super("Impossible de trouver le joueur possédant l'id " + id);
    }
    public JoueurNotFoundException(String username) {
        super("Impossible de trouver le joueur correspondant au nom d'utilisateur " + username);
    }
}
