package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDateTime;

@Entity
public class AvisEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NonNull
    private String description;
    @ManyToOne
    @NonNull
    private JeuEntity jeu;
    @ManyToOne
    @NonNull
    private JoueurEntity joueur;
    private Float note;
    private LocalDateTime dateDEnvoi;
    @ManyToOne
    private ModerateurEntity moderateur;

    public AvisEntity() {
    }

    public AvisEntity(Long id, String description, JeuEntity jeu, JoueurEntity joueur, Float note, LocalDateTime dateDEnvoi, ModerateurEntity moderateur) {
        this.id = id;
        this.description = description;
        this.jeu = jeu;
        this.joueur = joueur;
        this.note = note;
        this.dateDEnvoi = dateDEnvoi;
        this.moderateur = moderateur;
    }

    public AvisEntity(String description, JeuEntity jeu, JoueurEntity joueur, Float note, LocalDateTime dateDEnvoi, ModerateurEntity moderateur) {
        this.description = description;
        this.jeu = jeu;
        this.joueur = joueur;
        this.note = note;
        this.dateDEnvoi = dateDEnvoi;
        this.moderateur = moderateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JeuEntity getJeu() {
        return jeu;
    }

    public void setJeu(JeuEntity jeu) {
        this.jeu = jeu;
    }

    public JoueurEntity getJoueur() {
        return joueur;
    }

    public void setJoueur(JoueurEntity joueur) {
        this.joueur = joueur;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public LocalDateTime getDateDEnvoi() {
        return dateDEnvoi;
    }

    public void setDateDEnvoi(LocalDateTime dateDEnvoi) {
        this.dateDEnvoi = dateDEnvoi;
    }

    public ModerateurEntity getModerateur() {
        return moderateur;
    }

    public void setModerateur(ModerateurEntity moderateur) {
        this.moderateur = moderateur;
    }
}
