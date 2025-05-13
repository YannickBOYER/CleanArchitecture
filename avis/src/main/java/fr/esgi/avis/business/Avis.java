package fr.esgi.avis.business;

import java.time.LocalDateTime;

public class Avis {
    private Long id;
    private String description;
    private Jeu jeu;
    private Joueur joueur;
    private Float note;
    private LocalDateTime dateDEnvoi;
    private Moderateur moderateur;

    public Avis() {
    }

    public Avis(Long id, String description, Jeu jeu, Joueur joueur, Float note, LocalDateTime dateDEnvoi, Moderateur moderateur) {
        this.id = id;
        this.description = description;
        this.jeu = jeu;
        this.joueur = joueur;
        this.note = note;
        this.dateDEnvoi = dateDEnvoi;
        this.moderateur = moderateur;
    }

    public Avis(String description, Jeu jeu, Joueur joueur, Float note, LocalDateTime dateDEnvoi, Moderateur moderateur) {
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

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
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

    public Moderateur getModerateur() {
        return moderateur;
    }

    public void setModerateur(Moderateur moderateur) {
        this.moderateur = moderateur;
    }
}
