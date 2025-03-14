package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

@Entity
public abstract class UtilisateurEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(length=80)
    @Size(max=80)
    private String pseudo;
    @NonNull
    private String email;
    @NonNull
    private String motDePasse;

    protected UtilisateurEntity() {
    }

    protected UtilisateurEntity(Long id, String pseudo, String email, String motDePasse) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    protected UtilisateurEntity(String pseudo, String email, String motDePasse) {
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
