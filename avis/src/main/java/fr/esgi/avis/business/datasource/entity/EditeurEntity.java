package fr.esgi.avis.business.datasource.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class EditeurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull
    @NotBlank(message="Merci de préciser le nom de l'éditeur")
    @Size(min=2, message="Le nom de l'éditeur doit comporter au moins {min} caractères")
    private String nom;
}
