package fr.esgi.avis.business;

import fr.esgi.avis.business.Utilisateur;

import java.time.LocalDate;

public class Joueur extends Utilisateur {
    private LocalDate dateDeNaissance;

    public Joueur() {
    }

    public Joueur(Long id, String pseudo, String motDePasse, String email, LocalDate dateDeNaissance) {
        super(id, pseudo, motDePasse, email);
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
