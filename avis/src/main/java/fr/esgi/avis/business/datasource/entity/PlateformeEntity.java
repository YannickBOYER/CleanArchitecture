package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PlateformeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private LocalDate dateDeSortie;

    @ToString.Exclude
    @ManyToMany(mappedBy = "plateformes")
    private List<JeuEntity> jeux;

    public PlateformeEntity() {
    }

    public PlateformeEntity(Long id, String nom, LocalDate dateDeSortie, List<JeuEntity> jeux) {
        this.id = id;
        this.nom = nom;
        this.dateDeSortie = dateDeSortie;
        this.jeux = jeux;
    }

    public PlateformeEntity(String nom, LocalDate dateDeSortie) {
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

    public List<JeuEntity> getJeux() {
        return jeux;
    }

    public void setJeux(List<JeuEntity> jeux) {
        this.jeux = jeux;
    }
}
