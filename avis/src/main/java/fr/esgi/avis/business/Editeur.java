package fr.esgi.avis.business;

public class Editeur {
    private Long id;
    private String nom;

    public Editeur() {
    }

    public Editeur(Long id, String nom) {
        this.id = id;
        this.nom = nom;
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
