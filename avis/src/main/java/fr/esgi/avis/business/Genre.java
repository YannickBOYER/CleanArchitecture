package fr.esgi.avis.business;

public class Genre {
    private Long id;
    private String nom;

    public Genre(String nom) {
        this.nom = nom;
    }

    public Genre(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
