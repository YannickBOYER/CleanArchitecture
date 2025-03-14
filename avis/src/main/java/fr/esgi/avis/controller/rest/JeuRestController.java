package fr.esgi.avis.controller.rest;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.controller.rest.dto.in.JeuRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.JeuResponseDTO;
import fr.esgi.avis.controller.rest.mapper.JeuDtoMapper;
import fr.esgi.avis.usecase.usecase.JeuUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jeux")
public class JeuRestController {
    private final JeuUseCase useCase;
    private final JeuDtoMapper jeuDtoMapper;

    public JeuRestController(JeuUseCase useCase,
                             JeuDtoMapper jeuDtoMapper) {
        this.useCase = useCase;
        this.jeuDtoMapper = jeuDtoMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public JeuResponseDTO create(@RequestBody JeuRequestDTO requestDTO){
        final Jeu jeu = jeuDtoMapper.toBusiness(requestDTO);
        return jeuDtoMapper.toDto(useCase.save(jeu));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<JeuResponseDTO> findAll(){
        return useCase.findAll().stream().map(jeuDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public JeuResponseDTO findById(@PathVariable Long id){
        return jeuDtoMapper.toDto(useCase.findById(id));
    }
}
