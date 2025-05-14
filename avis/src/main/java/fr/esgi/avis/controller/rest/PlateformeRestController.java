package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.controller.rest.dto.out.PlateformeResponseDTO;
import fr.esgi.avis.controller.rest.mapper.PlateformeDtoMapper;
import fr.esgi.avis.usecase.usecase.PlateformeUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plateformes")
public class PlateformeRestController {
    private final PlateformeUseCase useCase;
    private final PlateformeDtoMapper plateformeDtoMapper;

    public PlateformeRestController(PlateformeUseCase useCase,
                                    PlateformeDtoMapper plateformeDtoMapper) {
        this.useCase = useCase;
        this.plateformeDtoMapper = plateformeDtoMapper;
    }

    @GetMapping()
    public List<PlateformeResponseDTO> findAll(){
        final List<Plateforme> plateformes = useCase.findAll();
        return plateformes.stream().map(plateformeDtoMapper::toDto).collect(Collectors.toList());
    }
}
