package fr.esgi.avis.controller.rest.dto.out;

import java.time.LocalDate;
import java.util.List;

public class JeuResponseDTO {
    public Long id;
    public String nom;
    public LocalDate dateDeSortie;
    public String image;
    public float prix;
    public String description;
    public GenreResponseDTO genre;
    public EditeurResponseDTO editeur;
    public ClassificationResponseDTO classification;
    public List<PlateformeResponseDTO> plateformes;
}
