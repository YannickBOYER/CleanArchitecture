package fr.esgi.avis.usecase.exception;

public class ModerateurNotFoundException extends NotFoundException{
    public ModerateurNotFoundException(Long id) {
        super("Impossible de trouver le moderateur possédant l'id " + id);
    }

    public ModerateurNotFoundException() {
        super("Aucun modérateur n'a été trouvé");
    }
}
