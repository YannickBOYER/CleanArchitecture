package fr.esgi.avis.business;

import java.time.LocalDate;
import java.util.List;

public class Jeu {
    private Long id;
    private String nom;
    private LocalDate dateDeSortie;
    private String image;
    private float prix;
    private String description;
    private Genre genre;
    private Editeur editeur;
    private Classification classification;
    private List<Plateforme> plateformes;

    public Jeu() {
    }

    public Jeu(Long id, String nom, LocalDate dateDeSortie, String image, float prix, String description, Genre genre, Editeur editeur, Classification classification, List<Plateforme> plateformes) {
        this.id = id;
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
        this.image = image;
        this.prix = prix;
        this.description = description;
        this.genre = genre;
        this.editeur = editeur;
        this.classification = classification;
        this.plateformes = plateformes;
    }

    public Jeu(String nom, LocalDate dateDeSortie, String image, float prix, String description, Genre genre, Editeur editeur, Classification classification, List<Plateforme> plateformes) {
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
        this.image = image;
        this.prix = prix;
        this.description = description;
        this.genre = genre;
        this.editeur = editeur;
        this.classification = classification;
        this.plateformes = plateformes;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public List<Plateforme> getPlateformes() {
        return plateformes;
    }

    public void setPlateformes(List<Plateforme> plateformes) {
        this.plateformes = plateformes;
    }
}
