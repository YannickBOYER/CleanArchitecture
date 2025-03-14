package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Entity
public class JeuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String nom;
    private LocalDate dateDeSortie;
    private String image;
    private float prix;
    @Lob
    private String description;
    @ManyToOne
    private GenreEntity genre;
    @NonNull
    @ManyToOne
    private EditeurEntity editeur;
    @ManyToOne
    private ClassificationEntity classification;
    @ManyToMany
    private List<PlateformeEntity> plateformes;

    public JeuEntity() {
    }

    public JeuEntity(Long id, String nom, LocalDate dateDeSortie, String image, float prix, String description, GenreEntity genre, EditeurEntity editeur, ClassificationEntity classification, List<PlateformeEntity> plateformes) {
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

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public EditeurEntity getEditeur() {
        return editeur;
    }

    public void setEditeur(EditeurEntity editeur) {
        this.editeur = editeur;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }

    public List<PlateformeEntity> getPlateformes() {
        return plateformes;
    }

    public void setPlateformes(List<PlateformeEntity> plateformes) {
        this.plateformes = plateformes;
    }
}
