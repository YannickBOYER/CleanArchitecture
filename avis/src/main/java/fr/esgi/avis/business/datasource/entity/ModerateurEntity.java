package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.Entity;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@ToString(callSuper = true)
public class ModerateurEntity extends UtilisateurEntity {
    private String numeroDeTelephone;

    public ModerateurEntity() {
    }

    public ModerateurEntity(Long id, String pseudo, String motDePasse, String email, String numeroDeTelephone) {
        super(id, pseudo, motDePasse, email);
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
