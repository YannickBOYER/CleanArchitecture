package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.controller.rest.dto.in.JeuRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.AvisResponseDTO;
import fr.esgi.avis.controller.rest.dto.out.JeuResponseDTO;
import fr.esgi.avis.controller.rest.mapper.AvisDtoMapper;
import fr.esgi.avis.controller.rest.mapper.JeuDtoMapper;
import fr.esgi.avis.usecase.usecase.JeuUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Jeux")
public class JeuRestController {
    private final JeuUseCase useCase;
    private final JeuDtoMapper jeuDtoMapper;
    private final AvisDtoMapper avisDtoMapper;

    public JeuRestController(JeuUseCase useCase,
                             JeuDtoMapper jeuDtoMapper,
                             AvisDtoMapper avisDtoMapper) {
        this.useCase = useCase;
        this.jeuDtoMapper = jeuDtoMapper;
        this.avisDtoMapper = avisDtoMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public JeuResponseDTO create(@RequestBody JeuRequestDTO requestDTO){
        final Jeu jeu = jeuDtoMapper.toBusiness(requestDTO);
        return jeuDtoMapper.toDto(useCase.save(jeu));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<JeuResponseDTO> findAll(Pageable pageable){
        final Page<Jeu> jeux = useCase.findAll(pageable);
        return jeux.map(jeuDtoMapper::toDto);
    }

    @GetMapping("/{id}/avis")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<AvisResponseDTO> avis(@PathVariable Long id, Pageable pageable){
        final Page<Avis> avis = useCase.avis(id, pageable);
        return avis.map(avisDtoMapper::toDto);
    }

    @GetMapping("/{id}")
    public JeuResponseDTO findById(@PathVariable Long id){
        return jeuDtoMapper.toDto(useCase.findById(id));
    }
}
