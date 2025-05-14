package fr.esgi.avis.controller.rest.dto.in;

import java.time.LocalDateTime;

public class AvisRequestDTO {
    public String description;
    public Long idJeu;
    public Long idJoueur;
    public Float note;
    public LocalDateTime dateDEnvoi;
    public Long idModerateur;
}
