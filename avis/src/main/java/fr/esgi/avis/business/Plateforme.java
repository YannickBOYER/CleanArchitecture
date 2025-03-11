package fr.esgi.avis.business;

import java.time.LocalDate;

public class Plateforme {
    private Long id;
    private String nom;
    private LocalDate dateDeSortie;

    public Plateforme() {
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
}
