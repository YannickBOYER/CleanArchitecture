package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.Entity;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@SuperBuilder
@ToString(callSuper = true)
public class JoueurEntity extends UtilisateurEntity {
    private LocalDate dateDeNaissance;

    public JoueurEntity() {
    }

    public JoueurEntity(Long id, String pseudo, String email, String motDePasse, LocalDate dateDeNaissance) {
        super(id, pseudo, email, motDePasse);
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
