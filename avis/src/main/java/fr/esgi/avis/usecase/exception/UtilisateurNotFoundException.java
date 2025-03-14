package fr.esgi.avis.usecase.exception;

public class UtilisateurNotFoundException extends RuntimeException {
    public UtilisateurNotFoundException(Long id) {
        super("Impossible de trouver l'utilisateur possédant l'id " + id);
    }
}
