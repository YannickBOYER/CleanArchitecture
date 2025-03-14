package fr.esgi.avis.business;

import java.time.LocalDate;
import java.util.List;

public class Plateforme {
    private Long id;
    private String nom;
    private LocalDate dateDeSortie;

    private List<Jeu> jeux;

    public Plateforme() {
    }

    public Plateforme(Long id, String nom, LocalDate dateDeSortie, List<Jeu> jeux) {
        this.id = id;
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
        this.jeux = jeux;
    }

    public Plateforme(Long id, String nom, LocalDate dateDeSortie) {
        this.id = id;
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
    }

    public Plateforme(String nom, LocalDate dateDeSortie) {
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
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

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public List<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(List<Jeu> jeux) {
        this.jeux = jeux;
    }
}
