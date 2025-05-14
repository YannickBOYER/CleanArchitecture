package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.controller.rest.dto.in.AvisRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.AvisResponseDTO;
import fr.esgi.avis.controller.rest.mapper.AvisDtoMapper;
import fr.esgi.avis.usecase.usecase.AvisUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avis")
public class AvisRestController {
    private final AvisUseCase useCase;
    private final AvisDtoMapper avisDtoMapper;

    public AvisRestController(AvisUseCase useCase,
                              AvisDtoMapper avisDtoMapper) {
        this.useCase = useCase;
        this.avisDtoMapper = avisDtoMapper;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AvisResponseDTO create(@RequestBody AvisRequestDTO requestDTO){
        final Avis avis = avisDtoMapper.toBusiness(requestDTO);
        return avisDtoMapper.toDto(useCase.save(avis));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id){
        useCase.delete(id);
    }
}
