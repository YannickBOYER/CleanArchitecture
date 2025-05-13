package fr.esgi.avis.business;

public class Moderateur extends Utilisateur{
    private String numeroDeTelephone;

    public Moderateur() {
    }

    public Moderateur(Long id, String pseudo, String motDePasse, String email, String numeroDeTelephone) {
        super(id, pseudo, motDePasse, email);
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
