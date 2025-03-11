package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Editeur;

import java.util.List;

public interface EditeurUseCase {
    Editeur save(Editeur editeur);
    List<Editeur> findAll();
    Editeur findById(Long id);
    void deleteById(Long id);
}
