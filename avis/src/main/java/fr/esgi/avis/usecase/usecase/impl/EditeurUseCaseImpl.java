package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.business.datasource.adapter.EditeurJpaAdapter;
import fr.esgi.avis.usecase.exception.EditeurNotFoundException;
import fr.esgi.avis.usecase.usecase.EditeurUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditeurUseCaseImpl implements EditeurUseCase {
    private final EditeurJpaAdapter adapter;

    public EditeurUseCaseImpl(EditeurJpaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Editeur save(Editeur editeur) {
        return adapter.save(editeur);
    }

    @Override
    public List<Editeur> findAll() {
        return adapter.findAll();
    }

    @Override
    public Editeur findById(Long id) {
        final Optional<Editeur> optionalEditeur = adapter.findById(id);
        if(optionalEditeur.isPresent()){
            return optionalEditeur.get();
        }else{
            throw new EditeurNotFoundException(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        final Editeur editeur = findById(id);
        adapter.delete(editeur);
    }
}
