package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Avis;

public interface AvisUseCase {
    void delete(Long id);
    Avis save(Avis avis);
}
