package fr.esgi.avis.controller.rest.dto.in;

import java.time.LocalDate;
import java.util.List;

public class JeuRequestDTO {
    public Long id;
    public String nom;
    public LocalDate dateDeSortie;
    public String image;
    public float prix;
    public String description;
    public Long genreId;
    public Long editeurId;
    public Long classificationId;
    public List<Long> plateformesIds;
}
