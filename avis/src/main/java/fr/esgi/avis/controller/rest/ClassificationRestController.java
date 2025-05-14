package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.controller.rest.dto.out.ClassificationResponseDTO;
import fr.esgi.avis.controller.rest.mapper.ClassificationDtoMapper;
import fr.esgi.avis.usecase.usecase.ClassificationUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classifications")
public class ClassificationRestController {
    private final ClassificationUseCase useCase;
    private final ClassificationDtoMapper classificationDtoMapper;


    public ClassificationRestController(ClassificationUseCase useCase,
                                        ClassificationDtoMapper classificationDtoMapper) {
        this.useCase = useCase;
        this.classificationDtoMapper = classificationDtoMapper;
    }

    @GetMapping()
    public List<ClassificationResponseDTO> findAll(){
        final List<Classification> classifications = useCase.findAll();
        return classifications.stream().map(classificationDtoMapper::toDto).collect(Collectors.toList());
    }
}
