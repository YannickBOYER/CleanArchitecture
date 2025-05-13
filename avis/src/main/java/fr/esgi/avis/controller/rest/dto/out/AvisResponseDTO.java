package fr.esgi.avis.controller.rest.dto.out;

import java.time.LocalDateTime;

public class AvisResponseDTO {
    public Long id;
    public String description;
    public JeuResponseDTO jeu;
    public JoueurResponseDTO joueur;
    public Float note;
    public LocalDateTime dateDEnvoi;
}
