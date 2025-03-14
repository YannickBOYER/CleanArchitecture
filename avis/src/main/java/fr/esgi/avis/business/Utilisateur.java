package fr.esgi.avis.business;

public abstract class Utilisateur {
    protected Long id;
    protected String pseudo;
    protected String motDePasse;
    protected String email;
    protected Utilisateur() {
    }
    protected Utilisateur(Long id, String pseudo, String motDePasse, String email) {
        this.id = id;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
