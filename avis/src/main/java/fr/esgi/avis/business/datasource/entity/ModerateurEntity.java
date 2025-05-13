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

    public ModerateurEntity(String pseudo, String email, String motDePasse, String numeroDeTelephone) {
        super(pseudo, email, motDePasse);
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public ModerateurEntity(Long id, String pseudo, String email, String motDePasse, String numeroDeTelephone) {
        super(id, pseudo, email, motDePasse);
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
