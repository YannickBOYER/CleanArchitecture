package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Editeur;

import java.util.List;
import java.util.Optional;

public interface EditeurJpaAdapter {
    Editeur save(Editeur editeur);
    List<Editeur>  findAll();
    Optional<Editeur> findById(Long id);
    void delete(Editeur editeur);
}
