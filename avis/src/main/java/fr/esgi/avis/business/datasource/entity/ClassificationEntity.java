package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class ClassificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String couleurRGB;

    public ClassificationEntity() {
    }
    public ClassificationEntity(Long id, String nom, String couleurRGB) {
        this.id = id;
        this.nom = nom;
        this.couleurRGB = couleurRGB;
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

    public String getCouleurRGB() {
        return couleurRGB;
    }

    public void setCouleurRGB(String couleurRGB) {
        this.couleurRGB = couleurRGB;
    }
}
