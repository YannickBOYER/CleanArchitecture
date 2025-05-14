package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.datasource.adapter.ClassificationJpaAdapter;
import fr.esgi.avis.usecase.exception.ClassificationNotFoundException;
import fr.esgi.avis.usecase.usecase.ClassificationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificationUseCaseImpl implements ClassificationUseCase {
    private final ClassificationJpaAdapter adapter;
    public ClassificationUseCaseImpl(ClassificationJpaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Classification findById(Long id) {
        Optional<Classification> optionalClassification = adapter.findById(id);
        if(optionalClassification.isPresent()){
            return optionalClassification.get();
        }else{
            throw new ClassificationNotFoundException(id);
        }
    }

    @Override
    public List<Classification> findAll() {
        return adapter.findAll();
    }
}
